package com.wyh.demo.domain.red;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author imai
 * @since 2021/4/12 11:48 下午
 */
@Data
@ToString
public class RedRecord {
    private Integer id;
    private Integer userId;
    private String redPacket;
    private Integer total;
    private BigDecimal amount;
    private Byte isActive;
    private Date createTime;
}
