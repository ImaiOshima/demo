package com.wyh.demo.dao;

import com.wyh.demo.domain.Item;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * @author imai
 * @since 2021/4/11 8:48 下午
 */
public interface ItemMapper {
    Item selectByCode(@Param("code")String code);
}
