package com.wyh.demo.test;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author imai
 * @since 2021/1/10 5:43 下午
 */
public class A {

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        swap(arr,4,0);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

