package com.NewsPublish.dao;

import com.NewsPublish.entity.Comments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentsMapper {
    List<Comments> list();
    List<Comments> listById(Integer newsId);
    void publish(Comments comments);
    void remove(Comments comments);
}
