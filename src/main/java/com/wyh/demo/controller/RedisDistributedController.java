package com.wyh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2020/11/26 上午1:03
 */
@RestController
public class RedisDistributedController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/redis")
    public void lock() throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        WatchDog watchDog;
        try {
            while (true) {
                Boolean hasLock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 3L, TimeUnit.SECONDS);
                if (hasLock) {
                    watchDog = new WatchDog(redisTemplate, uuid);
                    watchDog.start();
                    int num = (int)redisTemplate.opsForValue().get("num");
                    redisTemplate.opsForValue().set("num", num - 1);
                    System.out.println(num);
                    break;
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            String l = (String)redisTemplate.opsForValue().get("lock");
            if (l.equals(uuid)) {
                redisTemplate.delete("lock");
            }
        }
    }
}
