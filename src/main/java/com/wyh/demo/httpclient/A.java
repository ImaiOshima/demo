package com.wyh.demo.httpclient;

import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/5/19 10:16 下午
 */
@Component
public class A {
    B b = new B();
    public int get(){
        return b.getAge();
    }

    public String name(){
      return b.getName();
    }
}
