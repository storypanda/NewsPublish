package com.NewsPublish.controller;

import com.NewsPublish.entity.Comments;
import com.NewsPublish.entity.News;
import com.NewsPublish.service.NewsService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;
    @RequestMapping(value ="/news", method = RequestMethod.POST)
    public void postNews(@RequestBody News newsDetails, HttpServletResponse resp) throws Exception{
        Date date=new Date();
        Timestamp publishTime = new Timestamp(date.getTime());
        newsDetails.setPublishTime(publishTime);

        newsService.publishNews(newsDetails);
    }

    @RequestMapping(value ="/news", method = RequestMethod.GET)
    public void getNews(@RequestParam(required=false)  Integer categoryId, HttpServletResponse resp) throws Exception{
        if(categoryId!=null){
            List<News> news = newsService.listNewsByCategoryId(categoryId);
            JSONArray JSONObj = (JSONArray) JSON.toJSON(news);
            String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.getWriter().write(JsonStr);
        }else{
            List<News> news = newsService.listNews();
            JSONArray JSONObj = (JSONArray) JSON.toJSON(news);
            String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.getWriter().write(JsonStr);
        }
    }

    @RequestMapping(value ="/news", method = RequestMethod.PUT)
    public void putNews(@RequestBody News newsDetails, HttpServletResponse resp) throws Exception{
        Date date=new Date();
        Timestamp publishTime = new Timestamp(date.getTime());
        newsDetails.setPublishTime(publishTime);

        newsService.editNews(newsDetails);
    }

    @RequestMapping(value ="/news", method = RequestMethod.DELETE)
    public void deleteNews(@RequestBody News newsDetails, HttpServletResponse resp) throws Exception{
        newsService.removeNews(newsDetails);
    }

}
