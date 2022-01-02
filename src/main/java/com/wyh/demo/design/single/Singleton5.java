package com.wyh.demo.design.single;

/**
 * @author imai
 * @since 2021/3/28 4:35 下午
 * 双重校验锁
 */
public class Singleton5 {
    private volatile static Singleton5 singleton5 = null;
    /**
     *     为什么加上volatile 是因为对象空间分配 1.分配内存空间 2.初始化对象 3.把指针指向内存空间
     *     因为对象空间分配并不是一个原子操作 所以需要 volatile 防止重排序
     */
    private Singleton5(){}

    public static Singleton5 getInstance(){
        if(singleton5 == null){
            synchronized (Singleton5.class){
                if(singleton5 == null){
                    singleton5 = new Singleton5();
                }
            }
        }
        return singleton5;
    }
}
