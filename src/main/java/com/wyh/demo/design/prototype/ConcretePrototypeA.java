package com.wyh.demo.design.prototype;

/**
 * @author imai
 * @since 2021/3/28 5:08 下午
 */
public class ConcretePrototypeA implements Prototype<ConcretePrototypeA>{
    public String desc;

    public ConcretePrototypeA(String desc) {
        this.desc = desc;
    }

    @Override
    public ConcretePrototypeA clone() {
        return new ConcretePrototypeA(this.desc);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
