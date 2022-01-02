package com.wyh.demo.design.adapter;

/**
 * @author imai
 * @since 2021/2/13 8:09 下午
 * 适配器模式
 */
public interface Target {
    // 这个是Adaptee 有的方法
    public void sampleOperation1();

    // 这个是Adaptee 没有的方法
    public void sampleOperation2();
}
