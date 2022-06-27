package com.wyh.demo.sort;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/3/16 9:10 下午
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(insertionSort(arr)).forEach(x-> System.out.println(x));
    }

    public static int[] insertionSort(int[] arr){
        int len = arr.length;
        for(int i = 0;i<=len-1;i++){
            int value = arr[i];
            int j = i - 1;
            while(j>=0&&arr[j]>value){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
        return arr;
    }
}
