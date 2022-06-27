package com.wyh.demo.beanlive.aop.springaop.pojo.impl;

import com.wyh.demo.beanlive.aop.springaop.pojo.LogPrint;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/2/9 8:51 下午
 */

@Component
public class MyLogPrint implements LogPrint {
    @Override
    public void doPrint() {
        System.out.println("log print");
    }
}
