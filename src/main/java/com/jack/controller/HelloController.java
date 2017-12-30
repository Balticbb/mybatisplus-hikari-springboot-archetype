package com.jack.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;
import com.jack.dal.mapper.genmapper.UserMapper;
import com.jack.entity.User;
import com.jack.io.UserProtos;
import com.jack.io.UserProtos.ResponseUser;
import com.jack.mq.product.TopicProduct;
import com.jack.service.HelloService;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.controller
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/17 14:25
 * @version: V1.0
 */

@Controller
@RequestMapping("/hello-model")
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TopicProduct topicProduct;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    @ResponseBody
    public void hello(){
//        ResponseEntity<com.jack.dto.ResponseBody<>> a = new ResponseEntity<List>();
        Page<User> page = new Page<>(1, 2);
        page.setOrderByField("id");
        page.setAsc(false);
//        Page<User> userPage = helloService.selectUserPage(page,"jack");
//        return userPage;

        User user = new User();
        List<User> userList = user.selectPage(page,
                new EntityWrapper<User>().eq("name","jack")
        ).getRecords();

//        User user1 = new User();
//        user1.setAge(55);
//        user1.setName("HH");
//        user1.insert();
//        System.out.println(user1.getId());
//
//        int a[] = {1,3,5};
//        List<User> userList1 = userMapper.selectBatchIds(Arrays.asList(a));

        User a= new User();
        a.setName("PPP");
        a.setAge(222);
        a.setSex(2);
//        User b= new User();
//        b.setName("bbb");
//        b.setAge(111);
//        b.setSex(1);
//        User c= new User();
//        c.setName("ccc");
//        c.setAge(111);
//        c.setSex(1);
//        User d= new User();
//        d.setName("ddd");
//        d.setAge(111);
//        d.setSex(1);
        List<User> userList3 = new ArrayList<>(1);
        userList3.add(a);
//        userList3.add(b);
//        userList3.add(c);
//        userList3.add(d);

        boolean success = helloService.insertBatch(userList3,4);
        if(success){
            System.out.println("success");
//            System.out.println(a.getId()+"\t"+b.getId()+"\t"+c.getId()+"\t"+d.getId());
        }


//        page.setRecords(userList);


    }

    @RequestMapping("/mysql/test")
    public boolean mysqlTest(){


        try {
            User a = new User();
            a.setAge(2);
            a.setName("kkk");
            a.setSex(3);
            helloService.insert(a);
            User user = new User();
            user.setName("11");
            user.setSex(1);
            user.setAge(null);
            boolean result = helloService.insertAllColumn(user);
        }catch (Exception e){
//            log.error("\n----error {}",e);
            throw new RuntimeException("nihao");
        }

     return true;
    }

    @RequestMapping(value = "/proto",consumes = "application/x-protobuf",produces ="application/x-protobuf")
    @ResponseBody
    public ResponseUser getUserByproto(){

        ResponseUser responseUser =  UserProtos.ResponseUser.newBuilder().setName("jack_pro").setAge(18).setId(13).build();

        return responseUser;
    }

    @RequestMapping("test_proto")
    @ResponseBody
    public void test(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", "application/x-protobuf");
        requestHeaders.add("Content-type", "application/x-protobuf");
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
        ResponseEntity<ResponseUser> responseEntity = restTemplate.exchange("http://127.0.0.1:3333/hello-model/proto",HttpMethod.GET,requestEntity,ResponseUser.class);
        ResponseUser responseUser = responseEntity.getBody();

        System.out.println( new JsonFormat().printToString(responseUser));
//        protobuf对象转换成json：
//        String jsonFormat = JsonFormat.printToString(SomeProto);

//        json转成protobuf对象：
//        Message.Builder builder =SomeProto.newBuilder();
//        String jsonFormat = "json字符串";
//        JsonFormat.merge(jsonFormat, builder);
    }


    //测试MQ

    @RequestMapping("mq")
    @ResponseBody
    public void testTopicMq(){
        topicProduct.sendTopicMsg();
    }


    @RequestMapping("directMq")
    @ResponseBody
    public void testDirectMq(){
        topicProduct.sendTopicDirectMsg();
    }
}
