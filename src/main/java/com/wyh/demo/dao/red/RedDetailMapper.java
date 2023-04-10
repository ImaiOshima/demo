package com.wyh.demo.dao.red;

import com.wyh.demo.domain.red.RedDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author imai
 * @since 2021/4/13 12:01 上午
 */
@Mapper
public interface RedDetailMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(RedDetail redDetail);
    int insertSelective(RedDetail redDetail);
    RedDetail selectByPrimary(Integer id);
    int updateByPrimaryKeySelective(RedDetail redDetail);
    int updateByPrimaryKey(RedDetail redDetail);
}
