package com.wyh.demo.dao;

import com.wyh.demo.domain.UserReg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author imai
 * @since 2021/4/6 8:45 下午
 */
@Mapper
public interface UserRegMapper {
    UserReg selectByUserName(@Param("userName")String userName);

    int insertSelective(UserReg dto);
}
