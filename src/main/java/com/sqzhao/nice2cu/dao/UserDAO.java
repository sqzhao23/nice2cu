package com.sqzhao.nice2cu.dao;

import com.sqzhao.nice2cu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sqzhao
 */
public interface UserDAO extends JpaRepository<User,Integer> {

    User getByEmail(String email);

    User getByName(String name);

    User getByNameAndPassword(String email, String password);

    User getById(int id);


}
