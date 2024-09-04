package com.wyh.demo.test;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

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

        Date date = new Date();
        System.out.println(date.getTime());

        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a","a");
        linkedHashMap.put("b","b");
        linkedHashMap.put("a","c");

        for (Map.Entry entry:linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
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


