package com.wyh.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyh.demo.config.ds.DataBase;
import com.wyh.demo.dao.StudentMapper;
import com.wyh.demo.domain.Student;
import com.wyh.demo.domain.StudentInfo;

/**
 * @Classname StudentController
 * @Description TODO
 * @Author Imai
 * @Date 2023/4/10 16:33
 * @Created by 61635
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    @GetMapping("/select")
    @DataBase("db2")
    public List<Student> select(){
        return studentMapper.select();
    }

    @PostMapping("/insert")
    @DataBase("db2")
    public void insert(@RequestBody Student student){
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        studentMapper.insert(student);
    }

    @DeleteMapping("/delete/{id}")
    @DataBase("db2")
    public void delete(@PathVariable Integer id){
        studentMapper.delete(id);
    }

    @PostMapping("/update")
    @DataBase("db2")
    public void update(@RequestBody Student student){
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        studentMapper.update(student);
    }


    @GetMapping("/StudentInfo")
    @DataBase("db2")
    public List<StudentInfo> studentInfo(){
        return studentMapper.selectStudentInfo();
    }
}
