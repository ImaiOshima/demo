package com.wyh.demo.controller.kafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController(value = "/book")
public class UserKafkaController {

//    @Autowired
//    private UserProducerService producer;

    private AtomicLong atomicLong = new AtomicLong();

    private String topic = "topic-demo";

    @GetMapping("/kafka")
    public void sendKafka(){
//        producer.sendMessage(topic,"kafka message");
    }
}
