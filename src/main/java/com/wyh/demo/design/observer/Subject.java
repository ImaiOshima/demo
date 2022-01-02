package com.wyh.demo.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author imai
 * @since 2021/2/13 9:34 下午
 * 观察者模式
 */
public abstract class Subject {
    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer){
        list.add(observer);
    }

    public void detach(Observer observer){
        list.remove(observer);
    }

    public void notifyObservers(String state){
        for(Observer observer:list){
            observer.update(state);
        }
    }
}
