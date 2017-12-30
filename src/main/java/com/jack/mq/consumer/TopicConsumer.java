package com.jack.mq.consumer;

import com.jack.mq.MsgBody.TradleMsgBody;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright © 2017 上海金互行金融服务有限公司. All rights reserved. *
 *
 * @Title:
 * @Prject: mybatis-plus-test
 * @Package: com.jack.mq.consumer
 * @Description: ${todo}
 * @author: jack liujialin@jinhuhang.com.cn
 * @date: 2017/12/8 1:48
 * @version: V1.0
 */

@Configuration
@RabbitListener(queues = "topicQueue",containerFactory="rabbitListenerContainerFactory")
public class TopicConsumer {

    @Bean
    public Queue topicQueue(){
        return new Queue("topicQueue");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingExchangeToQueue(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("activity.#");
    }

    @RabbitHandler
    public void process(TradleMsgBody tradleMsgBody) {
        System.out.println("接受到消息");
        System.out.println(tradleMsgBody.toString());
    }
}
