package com.wyh.demo.service;

import com.wyh.demo.domain.praise.PraiseDto;

/**
 * @author imai
 * @since 2021/4/20 10:39 下午
 */
public interface IPraiseService {
    void addPraiseLock(PraiseDto dto) throws Exception;
    void cancelPraise(PraiseDto dto) throws Exception;

}
