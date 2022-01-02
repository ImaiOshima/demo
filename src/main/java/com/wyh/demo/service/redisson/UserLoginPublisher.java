package com.wyh.demo.service.redisson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/4/5 8:52 下午
 */
@Component
@Slf4j
public class UserLoginPublisher {
//    private static final String topicKey = "redissonUserLoginTopicKey";
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    public void sendMsg(UserLoginDto dto){
//        try{
//            if(dto != null){
//                log.info("记录用户登录成功的轨迹 {}",dto);
//                RTopic rTopic = redissonClient.getTopic(topicKey);
//                rTopic.publishAsync(dto);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
