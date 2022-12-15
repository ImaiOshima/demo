package com.wyh.demo.service.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Classname RocketMqListener
 * @Description TODO
 * @Date 2022/1/24 21:09
 * @Created by 61635
 */
//@Slf4j
//@Component
//@RocketMQMessageListener(topic="queue_test_topic",selectorExpression = "*",consumerGroup = "queue_test_topic" )
//public class RocketMqListener implements RocketMQListener<MessageExt> {
//
//    @Override
//    public void onMessage(MessageExt messageExt) {
//        byte[] body = messageExt.getBody();
//        String msg = new String(body);
//        log.info("接受到的消息：{}",msg);
//    }
//}
