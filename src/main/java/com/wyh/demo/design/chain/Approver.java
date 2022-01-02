package com.wyh.demo.design.chain;

/**
 * @author imai
 * @since 2021/3/29 9:52 下午
 */
public abstract class Approver {
    protected String name;
    protected Approver nextApprover;

    public Approver(String name){
        this.name = name;
    }

    public Approver setNextApprover(Approver nextApprover){
        this.nextApprover = nextApprover;
        return this.nextApprover;
    }

    public abstract void approve(int amount);
}
