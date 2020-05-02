package com.sqzhao.nice2cu.dao;

import com.sqzhao.nice2cu.pojo.News;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsDAO  extends JpaRepository<News,Integer> {
    List<News> findByOwnerId(int ownerId, Sort id);
}
