package com.wyh.demo.design.decorator;

/**
 * @author imai
 * @since 2021/2/13 9:11 下午
 */
public class Bird extends Change{
    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        System.out.println("Bird Move");
    }
}
