package com.wyh.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.wyh.demo.dao.ItemMapper;
import com.wyh.demo.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2021/4/11 9:18 下午
 */
@Service
@Slf4j
public class CachePassService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String keyPrefix = "item:";

    public Item getItemInfo(String itemCode) throws IOException {
        Item item = null;
        final String key = keyPrefix + itemCode;
        ValueOperations valueOperations = redisTemplate.opsForValue();
        if(redisTemplate.hasKey(key)){
            log.info("商品编号为 {}",itemCode);
            Object res =  valueOperations.get(key);
            if(res !=null && !Strings.isNullOrEmpty(res.toString())){
                item = objectMapper.readValue(res.toString(),Item.class);
            }else{
                log.info("缓存中并没有这个数据 数据库查询 商品编号为 {}",itemCode);
                item = itemMapper.selectByCode(itemCode);
                if(item !=null){
                     valueOperations.set(key,objectMapper.writeValueAsString(item));
                }else{
                    valueOperations.set(key,"",30, TimeUnit.SECONDS);
                }
            }
        }
        return item;
    }

    public Item getItemInfo2(String itemCode) throws IOException {
        Item item = null;
        final String key = keyPrefix + itemCode;
        ValueOperations valueOperations = redisTemplate.opsForValue();
        if(redisTemplate.hasKey(key)){
            log.info("商品编号为 {}",itemCode);
            Object res =  valueOperations.get(key);
            if(res !=null && !Strings.isNullOrEmpty(res.toString())){
                item = objectMapper.readValue(res.toString(),Item.class);
            }else{
                log.info("缓存中并没有这个数据 数据库查询 商品编号为 {}",itemCode);
                item = itemMapper.selectByCode(itemCode);
                if(item !=null){
                    valueOperations.set(key,objectMapper.writeValueAsString(item));
                }else{
                    valueOperations.set(key,"",30, TimeUnit.SECONDS);
                }
            }
        }
        return item;
    }
}
