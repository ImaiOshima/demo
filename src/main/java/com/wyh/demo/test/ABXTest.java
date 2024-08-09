package com.wyh.demo.test;

import java.util.LinkedHashSet;

public class ABXTest {
    public static void main(String[] args) {
        LinkedHashSet<String> zz = new LinkedHashSet<>();
        zz.add("a");
        zz.add("b");
        zz.add("v");
        zz.add("a");

        for (String s : zz){
            System.out.println(s);
        }
    }
}
