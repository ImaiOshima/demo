package com.wyh.demo.aop.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wyh.demo.aop.springaop.config.MySpringConfig;
import com.wyh.demo.aop.springaop.pojo.LogPrint;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname AopTest
 * @Description TODO
 * @Author Imai
 * @Date 2023/4/21 11:02
 * @Created by 61635
 */
public class AopTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MySpringConfig.class);
//        ApplicationContext xml = new ClassPathXmlApplicationContext("abc");
        LogPrint myLogPrint = (LogPrint) applicationContext.getBean("myLogPrint");
        myLogPrint.doPrint();
    }
}
