package com.sqzhao.nice2cu.service;

import com.sqzhao.nice2cu.dao.NewsDAO;
import com.sqzhao.nice2cu.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: nice2cu
 * @description: news业务类
 * @author: sqzhao
 * @create: 2020-05-01 13:33
 **/
@Service
public class NewsService {
    @Autowired
    NewsDAO newsDAO;

    public List<News> listByOwnerId(int OwnerId) {
        return newsDAO.findByOwnerId(OwnerId, Sort.by(Sort.Direction.DESC, "id"));
    }

    public News add(News news) {
        return newsDAO.save(news);
    }

    public void update(News news) {
        newsDAO.save(news);
    }

    public void deleteById(int id) {
        newsDAO.deleteById(id);
    }

    public List<News> list() {
        return newsDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
