package com.wyh.demo.design.strategy;

/**
 * @author imai
 * @since 2021/2/13 8:58 下午
 */
public class Client {
    /**
     * 根据 某种策略来计算价钱
     * @param args
     */
    public static void main(String[] args) {
        //高级会员的设定
        MemberStrategy strategy = new AdvanceMemberStrategy();
        Price price = new Price(strategy);
        double quote = price.quote(300);
        System.out.println("price 为" + quote);
    }
}
