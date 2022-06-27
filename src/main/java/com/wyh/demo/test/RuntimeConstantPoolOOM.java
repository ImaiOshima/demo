package com.wyh.demo.test;

import com.wyh.demo.sort.BubbleSort;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname RuntimeConstantPoolOOM
 * @Description TODO
 * @Date 2022/2/26 14:41
 * @Created by 61635
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder().append("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
