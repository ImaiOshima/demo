package com.wyh.demo.domain.red;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author imai
 * @since 2021/4/12 11:58 下午
 */
@Data
@ToString
public class RedDetail {
    private Integer id;
    private Integer recordId;
    private BigDecimal amount;
    private Byte isActive;
    private Date createTime;
}
