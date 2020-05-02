package com.sqzhao.nice2cu.controller;

import com.sqzhao.nice2cu.pojo.Friend;
import com.sqzhao.nice2cu.pojo.User;
import com.sqzhao.nice2cu.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: nice2cu
 * @description: friend控制器
 * @author: sqzhao
 * @create: 2020-04-29 22:08
 **/

@RestController
public class FriendController {
    @Autowired
    FriendService friendService;

    @PostMapping("addFriend")
    public void addAction(Friend friend, HttpServletRequest request, HttpSession session) {
        int friendId = Integer.parseInt(request.getParameter("friend_id"));
        String name = request.getParameter("friend_name");
        String alias = request.getParameter("friend_name");
        User user = (User)session.getAttribute("user");

        friend.setUserId(user.getId());
        friend.setFriendId(friendId);
        friend.setName(name);
        friend.setAlias(alias);
        friend.setPhoto(friendId);

        friendService.add(friend);
    }

    @GetMapping("listFriend")
    public List<Friend> list() throws Exception {
        List<Friend> friends = friendService.findAll();
        return friends;
    }
}
