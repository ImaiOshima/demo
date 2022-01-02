package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2021/2/6 8:39 下午
 */
public class FinalExample {
    int i;
    final int j;
    static FinalExample obj;

    FinalExample(){
        this.i = 1;
        this.j = 2;
    }

    public static void writer(){
        obj = new FinalExample();
    }

    public static void reader(){
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
    }
}
