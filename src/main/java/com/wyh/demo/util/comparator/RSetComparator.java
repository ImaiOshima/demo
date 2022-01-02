package com.wyh.demo.util.comparator;

import com.wyh.demo.domain.RSetDto;

import java.util.Comparator;

/**
 * @author imai
 * @since 2021/4/5 11:05 下午
 */
public class RSetComparator implements Comparator<RSetDto> {

    @Override
    public int compare(RSetDto o1, RSetDto o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
