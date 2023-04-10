package com.wyh.demo.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname LmadaMap
 * @Description TODO
 * @Author Imai
 * @Date 2023/4/10 11:33
 * @Created by 61635
 */
public class LamdbaListMap {
    public static void main(String[] args) {
        Map<Integer,String> a = new HashMap<>();
        Map<Integer,String> b = new HashMap<>();
        Map<Integer,String> c = new HashMap<>();
        Map<Integer,String> d = new HashMap<>();
        a.put(1,"a");
        b.put(2,"b");
        c.put(3,"c");
        d.put(1,"d");
        List<Map<Integer,String>> list = Arrays.asList(a,b,c,d);
        Integer key = 1;

        List<Map<Integer, String>> res = list.stream()
                .filter(x -> !x.containsKey(key))
                .collect(Collectors.toList());
        res.forEach(System.out::println);
    }
}
