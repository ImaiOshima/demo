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
}
