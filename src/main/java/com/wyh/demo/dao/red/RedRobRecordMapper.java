package com.wyh.demo.dao.red;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author imai
 * @since 2021/4/13 12:11 上午
 */
@Mapper
public interface RedRobRecordMapper {
    int deleteByPrimary(Integer id);
    int insert(RedRobRecordMapper record);
    int insertSelective(RedRobRecordMapper record);
    RedRobRecordMapper selectByPrimary(Integer id);
    int updateByPrimarySelective(RedRobRecordMapper record);
    int updateByPrimary(RedRobRecordMapper record);
}
