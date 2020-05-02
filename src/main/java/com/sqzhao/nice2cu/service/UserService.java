package com.sqzhao.nice2cu.service;

import com.sqzhao.nice2cu.dao.UserDAO;
import com.sqzhao.nice2cu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: nice2cu
 * @description: 用户业务类
 * @author: sqzhao
 * @create: 2020-04-25 13:46
 **/
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isEmailExist(String email) {
        User user = getByEmail(email);
        return null != user;
    }

    public boolean isNameExist(String name) {
        User user = getByName(name);
        return null != user;
    }

    public User getByEmail(String email){
        return userDAO.getByEmail(email);
    }

    public User getByName(String name){
        return userDAO.getByName(name);
    }

    public User get(int id){
        User user = userDAO.getById(id);
        return  user;
    }

    public void add(User user){
        userDAO.save(user);
    }

    public User getByNameAndPassword(String name, String password) {
        return userDAO.getByNameAndPassword(name,password);
    }

    public void update(User user) {
        userDAO.save(user);
    }
}
