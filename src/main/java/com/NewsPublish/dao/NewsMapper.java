package com.NewsPublish.dao;

import com.NewsPublish.entity.News;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsMapper {
    void publish(News news);
    List<News> list();
    List<News> listByCategoryId(Integer categoryId);
    void edit(News news);
    void delete(News news);
    void updateHitCount(News news);
}

