package com.wyh.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author imai
 * @since 2021/4/6 8:42 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReg {
    private Long id;
    private String userName;
    private String password;
    private Date createTime;
}
