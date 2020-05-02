package com.sqzhao.nice2cu.controller;

import com.sqzhao.nice2cu.pojo.User;
import com.sqzhao.nice2cu.service.FriendService;
import com.sqzhao.nice2cu.service.UserService;
import com.sqzhao.nice2cu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @program: nice2cu
 * @description: RESTFUL
 * @author: sqzhao
 * @create: 2020-04-27 10:56
 **/
@RestController
public class RESTController {
    @Autowired
    UserService userService;
    @Autowired
    FriendService friendService;

    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        String name =  user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        name = HtmlUtils.htmlEscape(name);
        email = HtmlUtils.htmlEscape(email);
        user.setName(email);
        boolean existEmail = userService.isEmailExist(email);
        if(existEmail){
            String message ="邮箱已经被使用,请检查正确性！";
            return Result.fail(message);
        }

        user.setName(name);
        boolean existName = userService.isNameExist(name);
        if(existName){
            String message ="用户名已经被使用,请重新输入！";
            return Result.fail(message);
        }


        user.setPassword(password);

        userService.add(user);

        return Result.success();
    }

    @PostMapping("/login")
    public Object login(@RequestBody User userParam, HttpSession session) {
        String name = userParam.getName();
        name = HtmlUtils.htmlEscape(name);

        User user1 = userService.getByName(name);
        if(null==user1){
            String message ="用户名不存在";
            return Result.fail(message);
        }

        User user2 = userService.getByNameAndPassword(name, userParam.getPassword());
        if(null==user2){
            String message ="用户名密码错误";
            return Result.fail(message);
        }
        else{
            session.setAttribute("user", user2);
            return Result.success();
        }
    }


    @PostMapping("/searchFriend")
    public Object addFriend(HttpServletRequest request, HttpSession session) {

        User user = (User)session.getAttribute("user");

        String type = request.getParameter("type");
        User friend;
        if (type.equals("name")) {
            String name = request.getParameter("info");
            name = HtmlUtils.htmlEscape(name);
            friend = userService.getByName(name);
            if (null == friend){
                return Result.fail("该用户不存在");
            }
            int friendId = friend.getId();
            if (friendService.isFriendIdExist(friendId)) {
                return Result.fail("该用户已经是好友");
            }
            if(friend.getId()==user.getId()){
                return Result.fail("不能添加自己为好友");
            }
        } else {
            String email = request.getParameter("info");
            email = HtmlUtils.htmlEscape(email);
            friend = userService.getByEmail(email);
            if (null == friend){
                return Result.fail("该用户不存在");
            }
            int friendId = friend.getId();
            if (friendService.isFriendIdExist(friendId)) {
                return Result.fail("该用户已经是好友");
            }
            if(friend.getId()==user.getId()){
                return Result.fail("不能添加自己为好友");
            }
        }
        return Result.success(friend);
    }

}
