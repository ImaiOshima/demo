package com.wyh.demo.rocketmq.producer;

import com.alibaba.fastjson.JSON;
import com.wyh.demo.rocketmq.constant.Constant;
import com.wyh.demo.rocketmq.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/5/16 3:02 下午
 */
//@Component
//@Slf4j
//public class Producer {
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//
//    public void sendMsg(Message msg){
//        log.info("发送报文:" + JSON.toJSONString(msg));
//        this.rocketMQTemplate.convertAndSend(Constant.TOPIC,JSON.toJSONString(msg));
//    }
//}
