package com.wyh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imai
 * @since 2021/2/15 6:34 下午
 */
@RestController
public class RedisTestController {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @GetMapping("/redis/hello")
    public String hello(){
        redisTemplate.opsForValue().set("key","value");
        return "Hello World";
    }
}
