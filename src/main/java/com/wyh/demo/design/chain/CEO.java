package com.wyh.demo.design.chain;

/**
 * @author imai
 * @since 2021/3/29 10:01 下午
 */
public class CEO extends Approver{

    public CEO(String name){
        super(name);
    }

    @Override
    public void approve(int amount) {
        if(amount <= 10000){
            System.out.println("许可" + name);
        }else{
            System.out.println("不许可 再见");
        }
    }
}
