package com.sqzhao.nice2cu.controller;

import com.sqzhao.nice2cu.pojo.Chat;
import com.sqzhao.nice2cu.pojo.Member;
import com.sqzhao.nice2cu.pojo.User;
import com.sqzhao.nice2cu.service.ChatService;
import com.sqzhao.nice2cu.service.MemberService;
import com.sqzhao.nice2cu.util.ImageUtil;
import com.sqzhao.nice2cu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @program: nice2cu
 * @description: chat控制器
 * @author: sqzhao
 * @create: 2020-04-30 20:59
 **/
@RestController
public class ChatController {
    @Autowired
    ChatService chatService;
    @Autowired
    MemberService memberService;

    @PostMapping("/addChat")
    public Object addChat(@RequestBody MultipartFile image, Chat chat,  HttpServletRequest request, HttpSession session) throws Exception {

        User user = (User)session.getAttribute("user");
        int ownerId = user.getId();
        String name = request.getParameter("chat_name");

        Chat chat1 = chatService.getByOwnerIdAndName(ownerId,name);
        if (null !=chat1) {
            String message ="此群聊名称已存在";
            return Result.fail(message);
        }

        String time = request.getParameter("time");
        String friendIds[] = request.getParameterValues("friends_id[]");

        chat.setName(name);
        chat.setOwnerId(ownerId);
        chat.setMember(friendIds.length+1);
        chat.setTime(time);

        chatService.add(chat);

        //循环新建member
        for (int i=0; i<friendIds.length; i++) {
            Member member = new Member();
            member.setChatId(chat.getId());
            member.setUserId(Integer.parseInt(friendIds[i]));
            memberService.add(member);
        }


        if(image!=null) {
            chat.setPhoto(chat.getId());
            saveOrUpdateImageFile(chat, image, request);
        }

        chatService.update(chat);

        return Result.success();
    }

    //保存图片
    public void saveOrUpdateImageFile(Chat chat, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/chat"));
        File file = new File(imageFolder,chat.getPhoto()+".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @GetMapping("/listChat")
    public List<Chat> list() {
        List<Chat> chats = chatService.findAll();
        return chats;
    }
}
