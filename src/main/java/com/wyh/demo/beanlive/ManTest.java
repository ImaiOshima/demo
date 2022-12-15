package com.wyh.demo.beanlive;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author imai
 * @since 2021/3/28 9:37 下午
 */
public class ManTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Man man = (Man) applicationContext.getBean("man");
        man.hello();
        System.out.println(man);
    }
}
