package com.wyh.demo.domain.book;

import lombok.Data;
import lombok.ToString;

/**
 * @author imai
 * @since 2021/4/21 10:51 下午
 */
@Data
@ToString
public class BookRobDto {
    private Integer userId;
    private String bookNo;
}
