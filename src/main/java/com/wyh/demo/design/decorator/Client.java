package com.wyh.demo.design.decorator;

/**
 * @author imai
 * @since 2021/2/13 9:12 下午
 */
public class Client {
    public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(sage);

        fish.move();
    }
}
