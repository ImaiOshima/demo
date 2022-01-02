package com.wyh.demo.design.factory;

/**
 * @author imai
 * @since 2021/3/28 5:23 下午
 */
public class ConcreteFactory2 extends Factory{
    @Override
    Product factoryMethod() {
        return new Product2();
    }
}
