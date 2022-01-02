package com.wyh.demo.design.chain;

/**
 * @author imai
 * @since 2021/3/29 9:55 下午
 */
public class Staff extends Approver{

    public Staff(String name){
       super(name);
    }

    @Override
    public void approve(int amount) {
        if(amount <= 1000){
            System.out.println("许可" + name);
        }else{
            System.out.println("不许可交给下个领导");
            nextApprover.approve(amount);
        }
    }
}
