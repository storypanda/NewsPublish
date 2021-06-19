package com.NewsPublish.controller;

import com.NewsPublish.entity.Comments;
import com.NewsPublish.service.CommentsService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @RequestMapping(value="/comments",method = RequestMethod.GET)
    public void getComments(@RequestParam(required=false)  Integer newsId, HttpServletResponse response) throws Exception{
        if(newsId!=null){
            List<Comments> comments = commentsService.listCommentsById(newsId);
            JSONArray JSONObj = (JSONArray) JSON.toJSON(comments);
            String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JsonStr);
        }else{
            List<Comments> comments = commentsService.listComments();
            JSONArray JSONObj = (JSONArray) JSON.toJSON(comments);
            String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JsonStr);
        }
    }

    @RequestMapping(value = "/comments",method = RequestMethod.POST)
    public void postComments(@RequestBody Comments comments) throws Exception{
        Date date=new Date();
        Timestamp publishTime = new Timestamp(date.getTime());
        comments.setTime(publishTime);

        commentsService.publishComments(comments);
    }

    @RequestMapping(value = "/comments",method = RequestMethod.DELETE)
    public void deleteComments(@RequestBody Comments comments) throws Exception{
        commentsService.removeComments(comments);
    }
}
