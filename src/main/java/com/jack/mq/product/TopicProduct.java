package com.jack.mq.product;

import com.jack.mq.MsgBody.TradleMsgBody;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.mq.product
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/8 1:47
 * @version: V1.0
 */
@Component
public class TopicProduct implements ChannelCallback{
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendTopicMsg(){
        List<Integer> nameList = new ArrayList<>();
        nameList.add(5);
        nameList.add(2);
        nameList.add(0);

        TradleMsgBody tradleMsgBody = new TradleMsgBody();
        tradleMsgBody.setAmount(new BigDecimal("3.141"));
        tradleMsgBody.setDate(new Date());
        tradleMsgBody.setNameList(nameList);
        tradleMsgBody.setRemark("注释");
        tradleMsgBody.setTradeType(1);
        System.out.println(tradleMsgBody.toString());
        System.out.println("准备发消息");
        amqpTemplate.convertAndSend("topicExchange","activity.pay.plan",tradleMsgBody);
        System.out.println("已发消息");
    }

    public void sendTopicDirectMsg(){
        List<Integer> nameList = new ArrayList<>();
        nameList.add(5);
        nameList.add(3);
        nameList.add(0);

        TradleMsgBody tradleMsgBody = new TradleMsgBody();
        tradleMsgBody.setAmount(new BigDecimal("3.141"));
        tradleMsgBody.setDate(new Date());
        tradleMsgBody.setNameList(nameList);
        tradleMsgBody.setRemark("注释");
        tradleMsgBody.setTradeType(2);
        System.out.println(tradleMsgBody.toString());
        System.out.println("准备发消息");
        amqpTemplate.convertAndSend("directExchange","activity.direct",tradleMsgBody);
//        amqpTemplate.convertSendAndReceive()
        System.out.println("已发消息");
    }

    @Override
    public Object doInRabbit(Channel channel) throws Exception {
        return null;
    }
}
