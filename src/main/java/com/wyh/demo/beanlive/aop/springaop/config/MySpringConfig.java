package com.wyh.demo.beanlive.aop.springaop.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author imai
 * @since 2021/2/9 9:21 下午
 */
@Configurable
@ComponentScan("com.wyh.demo.aop.springaop.*")
public class MySpringConfig {
}
