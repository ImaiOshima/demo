package com.wyh.demo.domain.praise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author imai
 * @since 2021/4/20 8:26 下午
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PraiseRankDto {
    private Integer blogId;
    private Long total;
}
