package com.jack.mq.consumer;

import com.jack.mq.MsgBody.TradleMsgBody;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.mq.consumer
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/8 2:55
 * @version: V1.0
 */

@Configuration
public class DirectConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "directQueue",durable = "true"),exchange = @Exchange(value = "directExchange",type = ExchangeTypes.DIRECT,durable = "true"),key = "activity.direct"))
    public void handleDirectMsg(@Payload TradleMsgBody tradleMsgBody){
        System.out.println(tradleMsgBody.toString());

    }
}
