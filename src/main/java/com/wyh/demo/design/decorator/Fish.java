package com.wyh.demo.design.decorator;

/**
 * @author imai
 * @since 2021/2/13 9:10 下午
 */
public class Fish extends Change{
    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move(){
        System.out.println("Fish Move");
    }
}
