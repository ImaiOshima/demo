package com.wyh.demo.service;

import com.wyh.demo.domain.praise.PraiseRankDto;

import java.util.List;

/**
 * @author imai
 * @since 2021/4/20 11:12 下午
 */
public interface IRedisPraise {
    void cachePraiseBlog(Integer blogId,Integer uId,Integer status) throws Exception;
    Long getCacheTotalBlog(Integer blogId) throws Exception;
    void rankBlogPraise() throws Exception;
    List<PraiseRankDto> getBlogPraiseRank() throws Exception;
}
