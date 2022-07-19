package com.wyh.demo.design.single;

/**
 * @author imai
 * @since 2021/1/15 12:34 上午
 * 单例模式 懒汉式 线程不安全
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}

