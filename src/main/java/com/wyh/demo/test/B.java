package com.wyh.demo.test;

/**
 * @Classname B
 * @Description TODO
 * @Date 2022/6/6 11:34
 * @Created by 61635
 */
public class B {
    private int a = 1234;
    static long C = 1111;
    public long test(long num){
        long ret = this.a + num + C;
        return ret;
    }
}
