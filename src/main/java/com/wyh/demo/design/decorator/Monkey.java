package com.wyh.demo.design.decorator;

/**
 * @author imai
 * @since 2021/2/13 9:08 下午
 */
public class Monkey implements TheGreatestSage{
    @Override
    public void move() {
        System.out.println("Monkey Move");
    }
}
