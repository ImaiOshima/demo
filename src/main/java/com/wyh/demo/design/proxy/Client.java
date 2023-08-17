package com.wyh.demo.design.proxy;

/**
 * @author imai
 * @since 2021/2/13 9:25 下午
 */
public class Client {
    public static void main(String[] args) {
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }
    // 代理模式总结 就是给一个方法加写内容 只要继承好或者实现就行
}
