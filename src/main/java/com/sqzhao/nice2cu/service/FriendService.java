package com.sqzhao.nice2cu.service;

import com.sqzhao.nice2cu.dao.FriendDAO;
import com.sqzhao.nice2cu.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: nice2cu
 * @description: 联系人业务类
 * @author: sqzhao
 * @create: 2020-04-29 22:06
 **/
@Service
public class FriendService {
    @Autowired
    FriendDAO friendDAO;

    public void add(Friend friend) {
        friendDAO.save(friend);
    }

    public List<Friend> findAll() {
        return friendDAO.findAll();
    }

    public boolean isFriendIdExist(int friendId) {
        Friend friend = getByFriendId(friendId);
        return null != friend;
    }

    public Friend getByFriendId(int friendId) {
        return friendDAO.getByFriendId(friendId);
    }
}
