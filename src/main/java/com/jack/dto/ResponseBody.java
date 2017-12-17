package com.jack.dto;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.dto
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/17 14:31
 * @version: V1.0
 */
public class ResponseBody<T> {

    private Integer code;
    private String message;
    private T body;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
