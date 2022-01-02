package com.wyh.demo.design.factory;

/**
 * @author imai
 * @since 2021/3/28 5:22 下午
 */
public class ConcreteFactory1 extends Factory {
    @Override
    Product factoryMethod() {
        return new Product1();
    }
}
