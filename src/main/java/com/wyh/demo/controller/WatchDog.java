package com.wyh.demo.controller;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2020/11/26 下午10:30
 */
public class WatchDog extends Thread{
    private RedisTemplate<String, Object> redisTemplate;
    private String uuid;

    public WatchDog(RedisTemplate<String, Object> redisTemplate, String uuid){
        this.redisTemplate = redisTemplate;
        this.uuid = uuid;
    }

    public void run(){
        while(true){
            try{
                Object redisUUID = redisTemplate.opsForValue().get("lock");
                if(redisUUID == null || !redisUUID.equals(uuid)){
                    break;
                }
                redisTemplate.expire("lock", 3L, TimeUnit.SECONDS);
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
    }
}
