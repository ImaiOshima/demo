package com.wyh.demo.service.redisson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/4/5 9:26 下午
 */
@Component
@Slf4j
public class UserLoginSubscriber{

//    private static final String topicKey = "redissonUserLoginTopicKey";
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    @Autowired
//    private  SysLogService sysLogService;

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        try{
//            RTopic rTopic = redissonClient.getTopic(topicKey);
//            rTopic.addListener(UserLoginDto.class, new MessageListener<UserLoginDto>() {
//                @Override
//                public void onMessage(CharSequence channel, UserLoginDto msg) {
//                    log.info("记录用户登录成功的轨迹-消费者-监听消费到消息: {}",msg);
//                    if(msg !=null){
//                        sysLogService.recordLog(msg);
//                    }
//                }
//            });
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
}
