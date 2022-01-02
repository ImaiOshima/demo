package com.wyh.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyh.demo.domain.User1;

/**
 * @author imai
 * @since 2021/3/31 8:50 下午
 */
@Mapper
public interface UserMapper  extends BaseMapper<User1> {

}
