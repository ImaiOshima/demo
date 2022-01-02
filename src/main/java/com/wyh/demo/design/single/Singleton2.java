package com.wyh.demo.design.single;

/**
 * @author imai
 * @since 2021/1/15 12:34 上午
 * 单例模式 懒汉式 线程不安全
 */
public class Singleton2 {
    private static Singleton2 singleton2 = null;

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

