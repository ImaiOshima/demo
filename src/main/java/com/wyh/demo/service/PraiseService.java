package com.wyh.demo.service;

import com.wyh.demo.dao.PraiseMapper;
import com.wyh.demo.domain.praise.Praise;
import com.wyh.demo.domain.praise.PraiseDto;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2021/4/20 10:44 下午
 */
@Service
@Slf4j
public class PraiseService implements IPraiseService{

    private static final String keyAddBlogLock = "RedisBlogPraiseAddLock";
    @Autowired
    private Environment env;
    @Autowired
    private PraiseMapper praiseMapper;
    @Autowired
    private IRedisPraise redisPraise;
    @Autowired
    private RedissonClient redissonClient;

    @Override public void addPraiseLock(PraiseDto dto) throws Exception {
        final String lockName = keyAddBlogLock + dto.getBlogId() + "-" + dto.getUserId();
        RLock lock = redissonClient.getLock(lockName);
        lock.lock(10L, TimeUnit.SECONDS);
        try{
            Praise p = praiseMapper.selectByBlogUserId(dto.getBlogId(), dto.getUserId());
            if(p == null){
                p = new Praise();
                BeanUtils.copyProperties(dto,p);
                Date praiseTime = new Date();
                p.setPraiseTime(praiseTime);
                p.setStatus(1);
                int total = praiseMapper.insertSelective(p);
                if(total > 0){
                    log.info("点赞博客 {}加分布式锁");
                    redisPraise.cachePraiseBlog(dto.getBlogId(),dto.getUserId(),1);
                }
            }
        }catch (Exception e){
            throw e;
        }finally {
            if(lock != null){
                lock.unlock();
            }
        }
    }

    @Override public void cancelPraise(PraiseDto dto) throws Exception {

    }
}
