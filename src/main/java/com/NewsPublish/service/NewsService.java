package com.NewsPublish.service;

import com.NewsPublish.dao.NewsMapper;
import com.NewsPublish.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    public void publishNews(News news){
        newsMapper.publish(news);
    }
    public List<News> listNews(){
        return newsMapper.list();
    }
    public List<News> listNewsByCategoryId(Integer categoryId){
        return newsMapper.listByCategoryId(categoryId);
    }
    public void editNews(News news){
        newsMapper.edit(news);
    }
    public void removeNews(News news){
        newsMapper.delete(news);
    }
    public void updateHitCountById(News news){
        news.setHitCount(news.getHitCount()+1);
        newsMapper.updateHitCount(news);
    }
}
