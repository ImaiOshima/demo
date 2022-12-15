package com.wyh.demo.design.prototype;

/**
 * @author imai
 * @since 2021/3/28 5:06 下午
 * 调用放
 */
public class Client {
    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA("concretePrototypeA");
        ConcretePrototypeA cloneA = concretePrototypeA.clone();
        cloneA.desc = "a";
        concretePrototypeA.desc = "b";
        System.out.println(cloneA);
        System.out.println(concretePrototypeA);
    }
}
