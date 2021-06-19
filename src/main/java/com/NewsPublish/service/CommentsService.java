package com.NewsPublish.service;

import com.NewsPublish.dao.CommentsMapper;
import com.NewsPublish.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    public void publishComments(Comments Comments){
        commentsMapper.publish(Comments);
    }
    public List<Comments> listComments(){
        return commentsMapper.list();
    }
    public List<Comments> listCommentsById(Integer newsId){
        return commentsMapper.listById(newsId);
    }
    public void removeComments(Comments comments){
        commentsMapper.remove(comments);
    }
}
