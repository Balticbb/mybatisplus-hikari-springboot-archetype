package com.jack.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jack.entity.User;
import com.jack.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/hello")
    @ResponseBody
    public Page<User> hello(){
//        ResponseEntity<com.jack.dto.ResponseBody<>> a = new ResponseEntity<List>();
        Page<User> page = new Page<>(1, 2);
//        Page<User> userPage = helloService.selectUserPage(page,"jack");
//        return userPage;

        User user = new User();
        List<User> userList = user.selectPage(page,
                new EntityWrapper<User>().eq("name","jack")
        ).getRecords();

        page.setRecords(userList);

        return page;

    }


}
