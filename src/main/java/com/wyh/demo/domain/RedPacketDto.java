package com.wyh.demo.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author imai
 * @since 2021/4/17 5:49 下午
 */
@Data
@ToString
public class RedPacketDto {
    private Integer userId;
    @NotNull
    private Integer total;
    @NotNull
    private Integer amount;
}
