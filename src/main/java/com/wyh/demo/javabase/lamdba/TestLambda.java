package com.wyh.demo.javabase.lamdba;

import org.junit.Test;

/**
 * @Classname TestLamdba
 * @Description TODO
 * @Date 2022/1/22 17:35
 * @Created by 61635
 */
public class TestLambda {
    @Test
    public void test01(){
        Runnable r1 = () -> System.out.println("hello lambda!");
        Thread thread = new Thread(r1);
        thread.start();
    }
}
