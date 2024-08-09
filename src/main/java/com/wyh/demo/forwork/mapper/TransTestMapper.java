package com.wyh.demo.forwork.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TransTestMapper {

    void updateById(@Param("id") int id,@Param("name") String name);

    void updateByName(@Param("name")String name,@Param("age") int age);
}
