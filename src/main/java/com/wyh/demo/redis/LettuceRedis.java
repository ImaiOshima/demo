package com.wyh.demo.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author imai
 * @since 2020/12/6 下午11:34
 */
public class LettuceRedis {
    public static void main(String[] args) {
        RedisURI redisUri = RedisURI.builder().withHost("47.116.137.230").withPort(6379)
                .withPassword("123456").withTimeout(Duration.of(10, ChronoUnit.SECONDS)).build();
        RedisClient redisClient = RedisClient.create(redisUri);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> redisCommands = connection.sync();
        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        String result = redisCommands.set("name", "throwable", setArgs);
        String value = redisCommands.get("name");
        System.out.println(result);
        System.out.println(value);
        connection.close();
        redisClient.shutdown();
    }
}
