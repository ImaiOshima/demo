package com.wyh.demo.aop.springaop.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author imai
 * @since 2021/2/9 8:53 下午
 */

@Aspect
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))")
    public void before(){
        System.out.println("before log");
    }

    @After("execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))")
    public void after(){
        System.out.println("after log");
    }

    @AfterReturning("execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))")
    public void afterRunning(){
        System.out.println("afterRunning log");
    }

    @AfterThrowing("execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing log");
    }
}
