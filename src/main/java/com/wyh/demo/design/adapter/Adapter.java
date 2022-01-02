package com.wyh.demo.design.adapter;

/**
 * @author imai
 * @since 2021/2/13 8:42 下午
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void sampleOperation2() {
        System.out.println("this is sampleOperation2");
    }
}
