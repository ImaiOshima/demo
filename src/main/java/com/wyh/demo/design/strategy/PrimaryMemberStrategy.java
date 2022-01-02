package com.wyh.demo.design.strategy;

/**
 * @author imai
 * @since 2021/2/13 8:51 下午
 */
public class PrimaryMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double bookPrice) {
        System.out.println("对于初级会员没有折扣");
        return bookPrice;
    }
}
