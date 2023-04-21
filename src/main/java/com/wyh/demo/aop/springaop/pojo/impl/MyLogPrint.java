package com.wyh.demo.aop.springaop.pojo.impl;

import com.wyh.demo.aop.springaop.pojo.LogPrint;

/**
 * @author imai
 * @since 2021/2/9 8:51 下午
 */

public class MyLogPrint implements LogPrint {
    @Override
    public void doPrint() {
        System.out.println("log print");
    }
}
