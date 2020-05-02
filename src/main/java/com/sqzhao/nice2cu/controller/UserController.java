package com.sqzhao.nice2cu.controller;

import com.sqzhao.nice2cu.pojo.User;
import com.sqzhao.nice2cu.service.UserService;
import com.sqzhao.nice2cu.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @program: nice2cu
 * @description: 用户控制器
 * @author: sqzhao
 * @create: 2020-04-25 14:04
 **/
@RestController
public class UserController {
    @Autowired UserService userService;

    @GetMapping("/user")
    public User get(HttpSession session) throws Exception {
        User user = (User)session.getAttribute("user");

        //刷新数据
        int user_id = user.getId();
        User user_user = userService.get(user_id);

        return user_user;
    }

    @PutMapping("/user")
    public void update(MultipartFile image, HttpServletRequest request) throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.get(id);

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String location = request.getParameter("location");
        String signature = request.getParameter("signature");
        user.setName(name);
        user.setGender(gender);
        user.setLocation(location);
        user.setSignature(signature);

        if(image!=null) {
            user.setPhoto(id);
            saveOrUpdateImageFile(user, image, request);
        }

        userService.update(user);
    }

    //保存图片
    public void saveOrUpdateImageFile(User user, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/user"));
        File file = new File(imageFolder,user.getPhoto()+".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @PutMapping("/password")
    public void update(HttpServletRequest request, HttpSession session) throws Exception {
        String password = request.getParameter("password");

        User user = (User)session.getAttribute("user");

        user.setPassword(password);

        userService.update(user);
    }

}
