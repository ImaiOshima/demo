package com.wyh.demo.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author imai
 * @since 2021/4/21 9:07 下午
 */
@Data
@ToString
public class UserRegDto {
    private String userName;
    private String password;
}
