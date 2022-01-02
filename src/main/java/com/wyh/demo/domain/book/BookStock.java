package com.wyh.demo.domain.book;

import lombok.Data;
import lombok.ToString;

/**
 * @author imai
 * @since 2021/4/21 10:20 下午
 */
@Data
@ToString
public class BookStock {
    private Integer id;
    private String bookNo;
    private Integer stock;
    private Byte isActive;
}
