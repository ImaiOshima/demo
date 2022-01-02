package com.wyh.demo.design.decorator;

/**
 * @author imai
 * @since 2021/2/13 9:09 下午
 */
public class Change implements TheGreatestSage{
    private TheGreatestSage sage;

    public Change(TheGreatestSage sage){
        this.sage = sage;
    }

    @Override
    public void move() {
        sage.move();
    }
}
