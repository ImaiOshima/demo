package com.wyh.demo.test;

/**
 * @author imai
 * @since 2022/8/31 3:54 下午
 */
public class SubstringTest {
    public static void main(String[] args) {
        String abc = "abczf";
        // substring 左闭右开 类似上面的结果是ab [0,1]
        System.out.println(abc.substring(0,2));
    }
}
