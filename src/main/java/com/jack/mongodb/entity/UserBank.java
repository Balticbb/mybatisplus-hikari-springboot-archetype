package com.jack.mongodb.entity;

import java.util.Date;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.mongodb.entity
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/20 13:45
 * @version: V1.0
 */
public class UserBank {
    private String name;

    private Long cardNum;

    private Date expireDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCardNum() {
        return cardNum;
    }

    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
