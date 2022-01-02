package com.wyh.demo.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author imai
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User implements Serializable {
    private Long id;
    @NotBlank
    private String name;

    private String sex;

    private Integer age;

    private String email;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    public User(String name,String sex,Integer age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
