package com.sqzhao.nice2cu.service;

import com.sqzhao.nice2cu.dao.ChatDAO;
import com.sqzhao.nice2cu.pojo.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: nice2cu
 * @description: 群聊业务类
 * @author: sqzhao
 * @create: 2020-04-30 20:57
 **/
@Service
public class ChatService {
    @Autowired
    ChatDAO chatDAO;

    public void add(Chat chat) {
        chatDAO.save(chat);
    }

    public void update(Chat chat) {
        chatDAO.save(chat);
    }

    public Chat getByOwnerIdAndName(int OwnerId ,String name) {
        return chatDAO.getByOwnerIdAndName(OwnerId ,name);
    }

    public List<Chat> findAll() {
        return chatDAO.findAll();
    }
}
