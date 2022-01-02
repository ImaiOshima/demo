package com.wyh.demo.service.redisson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/4/5 11:41 下午
 */
@Component
@Slf4j
public class QueuePublisher {
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    public void sendBasicMsg(String msg){
//        try{
//            final String queueName = "redissonBasicQueue";
//            RQueue<String> rQueue = redissonClient.getQueue(queueName);
//            rQueue.add(msg);
//            log.info("队列生产者 发送基本的消息 {}",msg);
//        }catch(Exception e){
//            log.error("队列的生产者 发生异常 {}",msg,e.fillInStackTrace());
//        }
//    }
}
