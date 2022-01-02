package com.wyh.demo.design.single;

/**
 * @author imai
 * @since 2021/3/28 4:23 下午
 * 懒汉式线程 安全
 */
public class Singleton4 {
    public static Singleton4 singleton4;

    private Singleton4(){
    }

    public static synchronized Singleton4 getInstance(){
        if(singleton4 == null){
            singleton4 =  new Singleton4();
        }
        return singleton4;
    }
}
