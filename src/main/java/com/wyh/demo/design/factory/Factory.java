package com.wyh.demo.design.factory;

/**
 * @author imai
 * @since 2021/3/28 5:19 下午
 */
public abstract class Factory {
    abstract Product factoryMethod();
    public void doSomething(){
        System.out.println("doSomething");
    }
}
