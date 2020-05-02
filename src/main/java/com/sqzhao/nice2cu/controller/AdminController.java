package com.sqzhao.nice2cu.controller;

import com.sqzhao.nice2cu.pojo.User;
import com.sqzhao.nice2cu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: nice2cu
 * @description: 控制器
 * @author: sqzhao
 * @create: 2020-04-25 13:54
 **/
@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping(value="/")
    public String index(){
        return "login";
    }

    @GetMapping(value = "/home")
    public String home(HttpSession session){

        User user = (User)session.getAttribute("user");

        session.removeAttribute("user");

        int userId = user.getId();
        User userUser = userService.get(userId);

        session.setAttribute("user",userUser);

        return "home";
    }


    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }


}
