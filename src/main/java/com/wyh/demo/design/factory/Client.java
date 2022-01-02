package com.wyh.demo.design.factory;

/**
 * @author imai
 * @since 2021/3/28 5:24 下午
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory1();
        Product product = factory.factoryMethod();

    }
}
