package com.wyh.demo.test;


/**
 * @author imai
 * @since 2021/1/10 5:43 下午
 */
public class A {
    private B b = new B();
    public static void main(String[] args) {
        A a = new A();
        long num = 4321;
        long ret = a.b.test(num);
        System.out.println(ret);
    }
}

