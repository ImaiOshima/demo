package com.wyh.demo.design.single;

/**
 * @author imai
 * @since 2021/1/15 12:30 上午 单例模式
 * 饿汉式 线程安全
 */
public class Singleton1 {

    private static Singleton1 single = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return single;
    }
}
