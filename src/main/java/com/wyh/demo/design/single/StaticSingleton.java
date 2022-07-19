package com.wyh.demo.design.single;

/**
 * @author imai
 * @since 2021/1/15 10:49 下午
 * 单例模式 懒汉式 静态内部类
 */
public class StaticSingleton {
    /**
     * 因为有虚拟机加载是线程安全的 所以完全可以使用这个
     */
    private StaticSingleton(){
    }

    public static class InstanceHolder{
        final static StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return InstanceHolder.INSTANCE;
    }
}
