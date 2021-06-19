package com.NewsPublish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan("com.NewsPublish.dao")
public class NewsPublishFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsPublishFinalApplication.class, args);
    }
    @Autowired
    private Environment env;
}

