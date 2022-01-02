package com.wyh.demo.service;

import com.wyh.demo.domain.RedPacketDto;

import java.math.BigDecimal;

/**
 * @author imai
 * @since 2021/4/17 5:58 下午
 */
public interface IRedPacketService {
    String handOut(RedPacketDto dto) throws Exception;
    BigDecimal rob(Integer userId,String redId) throws Exception;
}
