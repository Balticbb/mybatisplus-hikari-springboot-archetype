package com.jack.mongodb.repository;

import com.jack.mongodb.entity.UserDocument;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.mongodb.repository
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/18 17:27
 * @version: V1.0
 */


public interface UserReposity extends MongoRepository<UserDocument,Integer> {


}
