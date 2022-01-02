package com.wyh.demo.design.chain;

/**
 * @author imai
 * @since 2021/3/29 9:52 下午
 */
public class Client {
    public static void main(String[] args) {
        Approver approver = new Staff("张三");
        approver.setNextApprover(new Manager("关羽")).setNextApprover(new CEO("刘备"));

        approver.approve(1000);
        approver.approve(4000);
        approver.approve(9000);
    }
}
