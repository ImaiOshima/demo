package com.wyh.demo.domain.book;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author imai
 * @since 2021/4/21 10:21 下午
 */
@Data
@ToString
public class BookRob {
    private Integer id;
    private Integer userId;
    private String bookNo;
    private Date robTime;
}
