package com.wyh.demo.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

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
    }

    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

