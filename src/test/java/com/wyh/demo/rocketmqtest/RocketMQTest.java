package com.wyh.demo.rocketmqtest;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author imai
 * @since 2021/5/16 3:31 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RocketMQTest {
    //@Autowired
    //private Producer producer;
    //
    //@Test
    //public void rocketMqTest() throws InterruptedException {
    //    int i = 0;
    //    while(i<10){
    //        Message<String> msg = new Message<>();
    //        msg.setId(UUID.randomUUID().toString());
    //        msg.setContent("hello-"+i);
    //        i++;
    //        producer.sendMsg(msg);
    //        TimeUnit.SECONDS.sleep(5);
    //    }
    //}
}
