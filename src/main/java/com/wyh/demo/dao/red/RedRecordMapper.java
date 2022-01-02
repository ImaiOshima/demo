package com.wyh.demo.dao.red;

import com.wyh.demo.domain.red.RedRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author imai
 * @since 2021/4/13 12:08 上午
 */
@Mapper
public interface RedRecordMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(RedRecord redRecord);
    int insertSelective(RedRecord redRecord);
    RedRecord selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(RedRecord redRecord);
    int updateByPrimaryKey(RedRecord redRecord);
}
