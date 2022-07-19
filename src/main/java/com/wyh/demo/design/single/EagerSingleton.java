package com.wyh.demo.design.single;

/**
 * @author imai
 * @since 2021/1/15 12:30 上午 单例模式
 * 饿汉式 线程安全
 */
public class EagerSingleton {

    private static EagerSingleton single = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return single;
    }
}
