package com.wyh.demo.service.impl.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

//@Service
@Slf4j
public class UserProducerService {
    private static final Logger logger = LoggerFactory.getLogger(UserProducerService.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object o) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, o);
        future.addCallback(result -> logger.info("生产者成功发送消息到Topic:{} partition:{}的消息",
            result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
            ex -> logger.error("生产者发送消息失败，原因是{}:", ex.getMessage()));
    }
}
