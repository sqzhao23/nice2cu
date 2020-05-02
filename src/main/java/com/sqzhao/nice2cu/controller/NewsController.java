package com.sqzhao.nice2cu.controller;

import com.sqzhao.nice2cu.pojo.News;
import com.sqzhao.nice2cu.pojo.User;
import com.sqzhao.nice2cu.service.NewsService;
import com.sqzhao.nice2cu.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
 * @description: News控制器
 * @author: sqzhao
 * @create: 2020-05-01 13:55
 **/
@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/getMyNews")
    public List<News> getMyNews(HttpSession session) throws Exception {
        User user = (User)session.getAttribute("user");
        int ownerId = user.getId();
        List<News> news = newsService.listByOwnerId(ownerId);
        return news;
    }

    @PostMapping("/addNews")
    public void addNews(News news, MultipartFile image, HttpServletRequest request, HttpSession session) throws Exception {

        User user = (User)session.getAttribute("user");
        int ownerId = user.getId();
        String name = user.getName();
        int userPhoto = user.getId();
        String contentText = request.getParameter("contentText");
        String time = request.getParameter("time");

        news.setOwnerId(ownerId);
        news.setName(name);
        news.setUserPhoto(userPhoto);
        news.setContentText(contentText);
        news.setTime(time);

        newsService.add(news);

        if(image!=null) {
            news.setPhoto(news.getId());
            saveOrUpdateImageFile(news, image, request);
        }

        newsService.update(news);
    }

    //保存图片
    public void saveOrUpdateImageFile(News news, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/news"));
        File file = new File(imageFolder,news.getPhoto()+".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/deleteNews")
    public void deleteNews(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        newsService.deleteById(id);
    }

    @GetMapping("/getAllNews")
    public List<News> getALlNews() throws Exception {
        List<News> news = newsService.list();
        return news;
    }
}
