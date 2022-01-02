package com.wyh.demo.design.strategy;

/**
 * @author imai
 * @since 2021/2/13 8:53 下午
 */
public class AdvanceMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double bookPrice) {
        System.out.println("对于高级会员的折扣为20%");
        return bookPrice * 0.8;
    }
}
