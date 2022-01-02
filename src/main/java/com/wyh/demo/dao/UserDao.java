package com.wyh.demo.dao;

import com.wyh.demo.domain.Job;
import com.wyh.demo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author imai
 */
public interface UserDao {
    @Select("Select * from user where id = #{id,jdbcType=VARCHAR}")
    User findOneUserById(@Param(value = "id") Long id);

    @SelectProvider(type = SqlProvide.class, method = "findAllUser")
    List<User> findAllUser();

    @Results({@Result(column = "id", property = "id", id = true), @Result(column = "jobId", property = "job",
        one = @One(select = "com.wyh.demo.dao.userDao.getJobById", fetchType = FetchType.EAGER))})
    @Select("SELECT * FROM  User where id = #{id,jdbcType=INTEGER}")
    List<User> getOneUserJob(@Param(value = "id") String id);

    @Select("SELECT * FROM JOB WHERE ID = #{jobId}")
    Job getJobById(int jobId);

    @Insert("INSERT INTO USER(name,sex,age) VALUES(#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveUser(User user);

    @Insert("INSERT INTO TAB_USER(name,sex,age) VALUES(#{name},#{sex}.#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Object saveOne(User user);

    @Select("SELECT * FROM TAB_USER")
    List<User> list();
}
