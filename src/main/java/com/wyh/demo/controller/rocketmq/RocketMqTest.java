package com.wyh.demo.controller.rocketmq;

import cn.hutool.json.JSONUtil;
import com.wyh.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname RocketMqTest
 * @Description TODO
 * @Date 2022/1/24 21:12
 * @Created by 61635
 */

public class RocketMqTest {
    //@Autowired
    //private RocketMqProducer rocketMqProducer;
    //
    //@RequestMapping("/send")
    //public void sendMsg(){
    //    rocketMqProducer.sendMsg("我来测试下rocketmq");
    //}
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("PLEASE");
        producer.setNamesrvAddr("192.168.160.128:9876");
        producer.start();

        Message msg = new Message("TOPIC_TEST","hello rocketmq".getBytes());
        SendResult sendResult = null;
        sendResult = producer.send(msg);

        System.out.printf("%s%n",sendResult);

        //　发送带 Key 的消息
        msg = new Message("TOPIC_TEST", null, "ODS2020072615490001", "{\"id\":1, \"orderNo\":\"ODS2020072615490001\",\"buyerId\":1,\"sellerId\":1  }".getBytes());
        sendResult = producer.send(msg);
        //　输出结果
        System.out.printf("%s%n", sendResult);
        //　批量发送
        List<Message> msgs = new ArrayList<>();
        msgs.add( new Message("TOPIC_TEST", null, "ODS2020072615490002", "{\"id\":2, \"orderNo\":\"ODS2020072615490002\",\"buyerId\":1,\"sellerId\":3  }".getBytes()) );
        msgs.add( new Message("TOPIC_TEST", null, "ODS2020072615490003", "{\"id\":4, \"orderNo\":\"ODS2020072615490003\",\"buyerId\":2,\"sellerId\":4  }".getBytes()) );
        sendResult = producer.send(msgs);
        System.out.printf("%s%n", sendResult);

        msg = new Message("TOPIC_TEST", null, "ODS2020072615490001", JSONUtil.toJsonStr(new User("汪洋行","男",18)).getBytes());
        //　使用完毕后，关闭消息发送者
        producer.shutdown();
    }

//    public static void main(String[] args) {
//
//    }

}
