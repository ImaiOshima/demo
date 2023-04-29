package com.wyh.demo.test;


import java.util.*;

/**
 * @author imai
 * @since 2021/1/10 5:43 下午
 */
public class A {

    public static void main(String[] args) {
        Random random = new Random();
        int v = random.nextInt(30);
        int[] arr = new int[]{7,3,2,8,0};
        swap(arr,4,0);
        Arrays.stream(arr).forEach(System.out::println);
        HashMap<String,String> map = new HashMap<>();
        map.put("abc","a");
        HashSet<String> set = new HashSet<>();
        set.add("a");
    }

    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

