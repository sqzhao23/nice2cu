package com.sqzhao.nice2cu.dao;

import com.sqzhao.nice2cu.pojo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDAO extends JpaRepository<Chat,Integer> {
    Chat getByOwnerIdAndName(int ownerId, String name);
}
