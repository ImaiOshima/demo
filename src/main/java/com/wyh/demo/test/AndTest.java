package com.wyh.demo.test;

/**
 * @Classname AndTest
 * @Description TODO
 * @Author Imai
 * @Date 2023/4/10 0:03
 * @Created by 61635
 */
public class AndTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        if(a(a) && b(b)){
            System.out.println("&&");
        }
    }

    public static boolean a(int a){
        System.out.println(a);
        return a == 2;
    }

    public static boolean b(int b){
        System.out.println(b);
        return b == 2;
    }
}
