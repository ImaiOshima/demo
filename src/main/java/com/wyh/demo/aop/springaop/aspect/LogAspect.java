package com.wyh.demo.aop.springaop.aspect;

import com.wyh.demo.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
    public void before(JoinPoint jp){
        System.out.println("before log");
    }

    @After("execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))")
    public void after(JoinPoint jp){
        System.out.println("after log");
    }

    @AfterReturning(value = "execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))",returning = "result")
    public void afterRunning(Object result){
        System.out.println("afterRunning log");
    }
//
//    @AfterThrowing("execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))")
//    public void afterThrowing(JoinPoint jp,RuntimeException e){
//        System.out.println("afterThrowing log");
//    }

    @Around("execution(* com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint.doPrint(..))")
    public Object around(ProceedingJoinPoint jp) {
        return null;
    }
}
