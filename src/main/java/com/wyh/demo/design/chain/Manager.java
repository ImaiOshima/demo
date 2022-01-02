package com.wyh.demo.design.chain;

/**
 * @author imai
 * @since 2021/3/29 10:00 下午
 */
public class Manager extends Approver{

    public Manager(String name){
        super(name);
    }

    @Override
    public void approve(int amount) {
        if(amount <= 5000){
            System.out.println("许可"+name);
        }else{
            System.out.println("不许可 交给下个领导");
            nextApprover.approve(amount);
        }
    }
}
