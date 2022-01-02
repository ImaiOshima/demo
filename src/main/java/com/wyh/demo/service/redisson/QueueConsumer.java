package com.wyh.demo.service.redisson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/4/5 11:57 下午
 */
@Component
@Slf4j
public class QueueConsumer{
//
//    @Autowired
//    private RedissonClient redissonClient;

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        final String queueName = "redissonBasicQueue";
//        RQueue<String> rQueue = redissonClient.getQueue(queueName);
//        while(true){
//            String msg = rQueue.poll();
//            if(!Strings.isNotEmpty(msg)){
//                log.info("队列中监听到的消息 {}",msg);
//            }
//        }
//    }
}
