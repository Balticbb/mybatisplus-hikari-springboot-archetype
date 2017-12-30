package com.jack.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jack.dal.mapper.genmapper.UserMapper;
import com.jack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.service
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/17 15:09
 * @version: V1.0
 */

@Service
public class HelloService extends ServiceImpl<UserMapper,User>{

//    public Page<User> selectUserPage(Page<User> page, String state) {
//        page.setRecords(baseMapper.selectUserList(page,state));
//        return page;
//    }

}
