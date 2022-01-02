package com.wyh.demo.rocketmqtest;

import com.wyh.demo.rocketmq.entity.Message;
import com.wyh.demo.rocketmq.producer.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2021/5/16 3:31 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RocketMQTest {
    @Autowired
    private Producer producer;

    @Test
    public void rocketMqTest() throws InterruptedException {
        int i = 0;
        while(i<10){
            Message<String> msg = new Message<>();
            msg.setId(UUID.randomUUID().toString());
            msg.setContent("hello-"+i);
            i++;
            producer.sendMsg(msg);
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
