package com.wyh.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Classname StudentInfo
 * @Description TODO
 * @Author Imai
 * @Date 2023/4/10 19:50
 * @Created by 61635
 */
@Data
public class StudentInfo {
    private Integer id;
    private Integer studentId;
    private String name;
    private String sex;
    private Integer age;
    private Integer classId;
    private String address;
    private Date createTime;
    private Date updateTime;
    private String className;
}
