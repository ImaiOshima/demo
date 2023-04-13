package com.wyh.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wyh.demo.domain.Student;
import com.wyh.demo.domain.StudentInfo;

/**
 * @author imai
 * @since 2021/4/11 8:48 下午
 */
@Mapper
public interface StudentMapper {
    List<Student> select();
    int insert(Student student);
    void delete(int id);
    int update(Student student);
    List<StudentInfo> selectStudentInfo();
}
