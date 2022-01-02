package com.wyh.demo.design.observer;

/**
 * @author imai
 * @since 2021/2/13 9:42 下午
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.attach(observer);
        subject.change("new state");
    }
}
