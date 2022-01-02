package com.wyh.demo.design.prototype;

/**
 * @author imai
 * @since 2021/3/28 5:06 下午
 * 调用放
 */
public class Client {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype();
        Prototype clone = prototype.clone();
        System.out.println(prototype == clone);
    }
}
