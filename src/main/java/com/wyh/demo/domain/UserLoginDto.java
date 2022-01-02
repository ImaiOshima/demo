package com.wyh.demo.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author imai
 * @since 2021/4/5 9:00 下午
 */
@Data
@ToString
public class UserLoginDto implements Serializable {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    private Integer userId;
}
