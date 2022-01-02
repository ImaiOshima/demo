package com.wyh.demo.domain.red;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author imai
 * @since 2021/4/13 12:02 上午
 */
@Data
@ToString
public class RedRobRecord {
    private Integer id;
    private Integer userId;
    private String redPacket;
    private BigDecimal amount;
    private Date robTime;
    private Byte isActive;
}
