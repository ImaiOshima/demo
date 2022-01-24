package com.wyh.demo.service.rocketmq;

import com.wyh.demo.elasticsearch.service.MeetElasticSearchService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Classname RocketMqProducer
 * @Description TODO
 * @Date 2022/1/24 21:05
 * @Created by 61635
 */
@Component
public class RocketMqProducer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendMsg(String body){
        rocketMQTemplate.syncSend("queue_test_topic", MessageBuilder.withPayload(body).build());
    }
}
