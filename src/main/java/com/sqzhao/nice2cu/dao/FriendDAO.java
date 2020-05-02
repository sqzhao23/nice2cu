package com.sqzhao.nice2cu.dao;

import com.sqzhao.nice2cu.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sqzhao
 */
public interface FriendDAO extends JpaRepository<Friend,Integer> {

    @Override
    List<Friend> findAll();

    Friend getByFriendId(int friendId);
}
