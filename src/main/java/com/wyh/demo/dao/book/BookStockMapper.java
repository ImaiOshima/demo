package com.wyh.demo.dao.book;

import com.wyh.demo.domain.book.BookStock;
import org.apache.ibatis.annotations.Param;

/**
 * @author imai
 * @since 2021/4/21 10:23 下午
 */
public interface BookStockMapper {
    BookStock selectByBookNo(@Param("bookNo") String bookNo);
    int updateStock(@Param("bookNo") String bookNo);
    int updateStockWithLock(@Param("bookNo") String bookNo);
}
