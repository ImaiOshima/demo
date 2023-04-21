package com.wyh.demo.aop.springaop.config;

import com.wyh.demo.aop.springaop.aspect.LogAspect;
import com.wyh.demo.aop.springaop.pojo.impl.MyLogPrint;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author imai
 * @since 2021/2/9 9:21 下午
 */
@Configurable
@EnableAspectJAutoProxy
public class MySpringConfig {

    @Bean
    public MyLogPrint myLogPrint(){
        return new MyLogPrint();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
