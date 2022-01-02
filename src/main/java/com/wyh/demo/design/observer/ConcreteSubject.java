package com.wyh.demo.design.observer;

/**
 * @author imai
 * @since 2021/2/13 9:37 下午
 */
public class ConcreteSubject extends Subject{
    private String state;

    public String getState(){
        return state;
    }

    public void change(String state){
        this.state = state;
        System.out.println("主题状态:"+state);
        this.notifyObservers(state);
    }
}
