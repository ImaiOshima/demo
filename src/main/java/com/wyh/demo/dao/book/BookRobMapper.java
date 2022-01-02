package com.wyh.demo.dao.book;

import com.wyh.demo.domain.book.BookRob;
import org.apache.ibatis.annotations.Param;

/**
 * @author imai
 * @since 2021/4/21 10:37 下午
 */
public interface BookRobMapper {
    int insertSelective(BookRob record);
    int countBookNoUserId(@Param("userId") Integer userid,@Param("bookNo") String bookNo);
}
