package com.wyh.demo.dao;

import com.wyh.demo.domain.praise.Praise;
import com.wyh.demo.domain.praise.PraiseRankDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author imai
 * @since 2021/4/20 8:21 下午
 */
public interface PraiseMapper {
    int insertSelective(Praise record);
    Praise selectByBlogUserId(@Param("blogId") Integer blogId,@Param("uId") Integer uId);
    int countByBlogId(@Param("blogId") Integer blogId);
    int cancelByBlogId(@Param("blogId") Integer blogId,@Param("uId") Integer uId);
    List<PraiseRankDto> getPraiseRank();
}
