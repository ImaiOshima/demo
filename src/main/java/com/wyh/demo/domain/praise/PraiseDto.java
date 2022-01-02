package com.wyh.demo.domain.praise;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author imai
 * @since 2021/4/20 10:35 下午
 */
@Data
@ToString
public class PraiseDto {
    @NotNull
    private Integer blogId;
    @NotNull
    private Integer userId;
}
