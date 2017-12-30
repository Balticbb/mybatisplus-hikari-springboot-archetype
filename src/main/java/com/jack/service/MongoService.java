package com.jack.service;

import com.jack.mongodb.entity.Author;
import com.jack.mongodb.entity.Book;
import com.jack.mongodb.entity.UserBank;
import com.jack.mongodb.entity.UserDocument;
import com.jack.mongodb.repository.AuthorReposity;
import com.jack.mongodb.repository.UserReposity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.PredicateOperation;
import com.querydsl.core.types.PredicateTemplate;
import com.querydsl.mongodb.morphia.MorphiaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.service
 * @Description:
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/19 16:29
 * @version: V1.0
 */

@Service
public class MongoService {
    @Autowired
    private UserReposity userReposity;

    @Autowired
    private AuthorReposity authorReposity;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserDocument> getAllUserDocument(){
//        return mongoTemplate.findAll(UserDocument.class,"user_info");
//        userReposity.findAll()
        return userReposity.findAll();
    }


    public List<Author> findDocument(){
//        MorphiaQuery morphiaQuery
//        return authorReposity.findByName("jack");

        Criteria criteria = Criteria.where("userBankList.name").is("中国建设银行上海河南南路支ii行");
        Query query = new Query();
        query.addCriteria(criteria);
        return  mongoTemplate.find(query,Author.class,"author_info");
//        return mongoTemplate.findAll(Author.class);
//        authorReposity.findOne(Example)
    }



    public Author addDocument(){

        Book book = new Book();
        book.setBookName("春娇与志明");
        book.setPrice(132.62f);
        book.setPublishDate(new Date());

        Book book1 = new Book();
        book1.setBookName("三国演义");
        book1.setPrice(1000.56F);
        book1.setPublishDate(new Date());

        List<Book> bookList = new ArrayList<>(6);
        bookList.add(book);
        bookList.add(book1);
        UserBank userBank = new UserBank();
        userBank.setCardNum(1234567890123456789L);
        userBank.setName("中国建设银行上海河南南路支行");
        UserBank userBank1 = new UserBank();
        userBank1.setCardNum(1234567890123456789L);
        userBank1.setName("中国建设银行上海河南南路支行");
        List<UserBank> userBankList = new ArrayList<>(15);
        userBankList.add(userBank);
        userBankList.add(userBank1);

        Author author = new Author();
        author.setAge(18);
        author.setName("jack");
        author.setUserBankList(userBankList);
        author.setBookList(bookList);
        author = authorReposity.save(author);
        return author;
    }

    public boolean updateDocument(){

        Query query = new Query();
        Criteria criteria = new Criteria("userBankList.name").is("中国建设银行上海河南南路支行");
        query.addCriteria(criteria);

        Update update = new Update();
        update.set("name","baltic");
//        update.set("userBankList.name","中国建设银行上海河南北路支行");
        return mongoTemplate.updateFirst(query,update,Author.class).isUpdateOfExisting();

    }

    public void deleteDocumnet(){

    }



    public void addInnerDocument(){

    }

    public void updateInnerDocument(){

    }

    public void deleteInnerDocument(){

    }





}
