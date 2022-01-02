package com.wyh.demo.service;

import com.wyh.demo.dao.UserRegMapper;
import com.wyh.demo.domain.UserReg;
import com.wyh.demo.domain.UserRegDto;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2021/4/6 8:31 下午
 */
@Service
@Slf4j
public class UserRegService {
    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private UserRegMapper userRegMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public void userRegWithLock(UserRegDto dto) throws Exception{
        final String key = dto.getUserName() + "-lock";
        final String value = System.nanoTime() + ""+ UUID.randomUUID();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Boolean res = valueOperations.setIfAbsent(key, value);
        if(res){
            redisTemplate.expire(key,20L,TimeUnit.SECONDS);
            try{
                UserReg reg = userRegMapper.selectByUserName(dto.getUserName());
                if(reg == null){
                    log.info("--加了分布式");
                    UserReg entity = new UserReg();
                    BeanUtils.copyProperties(dto,entity);
                    entity.setCreateTime(new Date());
                    userRegMapper.insertSelective(entity);
                }else{
                    throw new Exception("用户信息已经存在！");
                }
            }catch (Exception e){
                throw e;
            }finally {
                if(value.equals(valueOperations.get(key).toString())){
                    redisTemplate.delete(key);
                }
            }
        }
    }
}
