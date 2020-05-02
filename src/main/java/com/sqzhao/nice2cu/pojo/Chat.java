package com.sqzhao.nice2cu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @program: nice2cu
 * @description: 聊天实体类
 * @author: sqzhao
 * @create: 2020-04-25 13:40
 **/
@Entity
@Table(name = "chat")
@DynamicUpdate
@DynamicInsert
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer"})
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int ownerId;
    private String name;
    private int photo;
    private int member;
    private String time;

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getMember() {
        return member;
    }
    public void setMember(int member) {
        this.member = member;
    }
    public int getPhoto() {
        return photo;
    }
    public void setPhoto(int photo) {
        this.photo = photo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
