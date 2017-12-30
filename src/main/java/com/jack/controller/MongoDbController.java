package com.jack.controller;

import com.jack.mongodb.entity.Author;
import com.jack.mongodb.entity.UserDocument;
import com.jack.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.controller
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/19 16:33
 * @version: V1.0
 */

@RestController
@RequestMapping("/mongodb")
public class MongoDbController {

    @Autowired
    private MongoService mongoService;



    @RequestMapping("/user")
    public List<UserDocument> getUserDocument(){
        return mongoService.getAllUserDocument();
    }

    @RequestMapping("/author/addDocument")
    public Author addDocument(){
        Author author = mongoService.addDocument();
        System.out.println(author.getId());
        return author;
    }

    @RequestMapping("/author/findByname")
    public List<Author> findByname(){
        return mongoService.findDocument();
    }

    @RequestMapping("/author/update")
    public boolean update(){
        return mongoService.updateDocument();
    }



}
