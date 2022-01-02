package com.wyh.demo.test;

/**
 * @author imai
 * @since 2021/2/19 1:07 上午
 * 单例模式默写 饿汉式 懒汉式
 */
public class SingletonTest {
    //线程安全饿汉式
    private SingletonTest(){}

    private static SingletonTest instance = new SingletonTest();

    public SingletonTest getInstance(){
        return instance;
    }

    //线程安全懒汉式
    private static volatile SingletonTest instance2;

    public static SingletonTest getInstance2(){
        if(instance2 == null){
            synchronized(SingletonTest.class){
                if(instance2 == null){
                    instance2 = new SingletonTest();
                }
            }
        }
        return instance2;
    }

}
