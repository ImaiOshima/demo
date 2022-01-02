package com.wyh.demo.service;

import com.wyh.demo.dao.red.RedDetailMapper;
import com.wyh.demo.dao.red.RedRecordMapper;
import com.wyh.demo.dao.red.RedRobRecordMapper;
import com.wyh.demo.domain.RedPacketDto;
import com.wyh.demo.domain.red.RedDetail;
import com.wyh.demo.domain.red.RedRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/17 6:41 下午
 */
@Service
@Slf4j
public class RedService implements IRedService{

    @Autowired
    private RedRecordMapper redRecordMapper;

    @Autowired
    private RedDetailMapper redDetailMapper;

    @Autowired
    private RedRobRecordMapper redRobRecordMapper;

    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void recordRedPacket(RedPacketDto dto, String redId, List<Integer> list)
        throws Exception {
        RedRecord redRecord = new RedRecord();
        redRecord.setUserId(dto.getUserId());
        redRecord.setRedPacket(redId);
        redRecord.setTotal(dto.getTotal());
        redRecord.setAmount(BigDecimal.valueOf(dto.getAmount()));
        redRecord.setCreateTime(new Date());
        redRecordMapper.insertSelective(redRecord);

        RedDetail redDetail;
        for(Integer i:list){
            redDetail = new RedDetail();
            redDetail.setRecordId(redRecord.getId());
            redDetail.setAmount(BigDecimal.valueOf(i));
            redDetail.setCreateTime(new Date());
            redDetailMapper.insertSelective(redDetail);
        }
    }

    @Override
    @Async
    public void recordRobRedPacket(Integer userId, String redId, BigDecimal amount)
        throws Exception {

    }
}
