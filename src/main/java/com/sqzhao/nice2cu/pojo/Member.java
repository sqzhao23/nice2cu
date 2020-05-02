package com.sqzhao.nice2cu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @program: nice2cu
 * @description: 群聊成员实体类
 * @author: sqzhao
 * @create: 2020-05-01 12:42
 **/
@Entity
@Table(name = "member")
@DynamicUpdate
@DynamicInsert
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer"})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int chatId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
