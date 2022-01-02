package com.wyh.demo.service;

import com.wyh.demo.domain.praise.PraiseRankDto;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2021/4/20 11:21 下午
 */
@Service
@Slf4j
public class RedisPraise implements IRedisPraise{

    private static final String keyBlog = "RedisBlogPraiseMap";

    @Autowired
    private RedissonClient redissonClient;

    @Override public void cachePraiseBlog(Integer blogId, Integer uId, Integer status)
        throws Exception {
        final String lockName =
            new StringBuffer("blogRedissonPraiseLock").append(blogId).append(uId).append(status).toString();
        RLock rLock = redissonClient.getLock(lockName);
        Boolean res = rLock.tryLock(100,10, TimeUnit.SECONDS);
        try{
            if(res){
                if(blogId != null&& uId !=null && status!=null){
                    final String key = blogId + ":" + uId;
                    RMap<String,Integer> praiseMap = redissonClient.getMap(lockName);
                    if(1 == status){
                        praiseMap.putIfAbsent(key,uId);
                    }else if(0 == status){
                        praiseMap.remove(key);
                    }
                }
            }
        }catch (Exception e){
            throw e;
        }finally {
            if(rLock != null){
                rLock.forceUnlock();
            }
        }
    }

    @Override public Long getCacheTotalBlog(Integer blogId) throws Exception {
        return null;
    }

    @Override public void rankBlogPraise() throws Exception {

    }

    @Override public List<PraiseRankDto> getBlogPraiseRank() throws Exception {
        return null;
    }
}
