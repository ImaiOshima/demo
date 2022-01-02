package com.wyh.demo.design.prototype;

/**
 * @author imai
 * @since 2021/3/28 5:08 下午
 */
public class ConcretePrototype extends Prototype{

    @Override
    public Prototype clone() {
        return new ConcretePrototype();
    }
}
