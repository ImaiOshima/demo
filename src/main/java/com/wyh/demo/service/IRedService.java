package com.wyh.demo.service;

import com.wyh.demo.domain.RedPacketDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/17 6:37 下午
 */
public interface IRedService {
    void recordRedPacket(RedPacketDto dto,String redId, List<Integer> list) throws Exception;
    void recordRobRedPacket(Integer userId,String redId, BigDecimal amount) throws Exception;
}
