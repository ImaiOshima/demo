package com.wyh.demo.design.strategy;

/**
 * @author imai
 * @since 2021/2/13 8:56 下午
 */
public class Price {
    private MemberStrategy strategy;

    public Price(MemberStrategy strategy){
        this.strategy = strategy;
    }

    public double quote(double bookPrice){
        return this.strategy.calcPrice(bookPrice);
    }
}
