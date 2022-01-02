package com.wyh.demo.design.observer;

/**
 * @author imai
 * @since 2021/2/13 9:41 下午
 */
public class ConcreteObserver implements Observer{
    private String observerState;
    @Override
    public void update(String state) {
        observerState = state;
        System.out.println("状态为:"+observerState);
    }
}
