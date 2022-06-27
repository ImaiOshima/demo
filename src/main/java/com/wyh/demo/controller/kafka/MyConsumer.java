package com.wyh.demo.controller.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author imai
 * @since 2021/3/26 10:08 下午
 */
//@Component
public class MyConsumer {
    @KafkaListener(topics = "topic-demo",groupId = "testGroup")
    public void listen(ConsumerRecord<String,String> record){
        String value = record.value();
        System.out.println(value);
    }


}
