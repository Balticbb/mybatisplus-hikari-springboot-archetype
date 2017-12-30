package com.jack.mongodb.repository;

import com.jack.mongodb.entity.Author;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.QueryDslMongoRepository;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.mongodb.repository
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/20 13:52
 * @version: V1.0
 */
public interface AuthorReposity extends MongoRepository<Author,String>{
//public class AuthorReposity extends QueryDslMongoRepository<Author,String>{
//
//    public AuthorReposity(MongoEntityInformation<Author, String> entityInformation, MongoOperations mongoOperations) {
//        super(entityInformation, mongoOperations);
//    }
//
//    public AuthorReposity(MongoEntityInformation<Author, String> entityInformation, MongoOperations mongoOperations, EntityPathResolver resolver) {
//        super(entityInformation, mongoOperations, resolver);
//    }


    List<Author> findByName(String name);
    List<Author> findByNameLike(String name);

}
