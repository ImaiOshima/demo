package com.wyh.demo.design.strategy;

/**
 * @author imai
 * @since 2021/2/13 8:52 下午
 */
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double bookPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return bookPrice * 0.9;
    }
}
