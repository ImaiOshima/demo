package com.wyh.demo.service;

import com.wyh.demo.domain.RedPacketDto;
import com.wyh.demo.util.red.RedPacketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/17 6:00 下午
 */
@Service
@Slf4j
public class RedPacketService implements IRedPacketService{

    private static final String keyPrefix = "redis:red:packet:";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IRedService iRedService;

    @Override public String handOut(RedPacketDto dto) throws Exception {
        if(dto.getTotal() > 0 && dto.getAmount() > 0){
            List<Integer> list = RedPacketUtil.divideRedPackage(dto.getAmount(),dto.getTotal());
            String timeStamp = String.valueOf(System.nanoTime());
            String redId =
                new StringBuffer(keyPrefix).append(dto.getUserId()).append(":").append(timeStamp).toString();
            redisTemplate.opsForList().leftPushAll(redId,list);
            String redTotalKey = redId+":total";
            redisTemplate.opsForValue().set(redTotalKey,dto.getTotal());
            iRedService.recordRedPacket(dto,redId,list);
            return redId;
        }else{
            throw new Exception("系统异常");
        }
    }

    @Override public BigDecimal rob(Integer userId, String redId) throws Exception {
        return null;
    }
}
