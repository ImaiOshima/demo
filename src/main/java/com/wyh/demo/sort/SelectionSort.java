package com.wyh.demo.sort;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/3/16 9:02 下午
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(selectionSort(arr)).forEach(x-> System.out.println(x));
    }

    public static int[] selectionSort(int[] arr){
        int len = arr.length;
        int min = Integer.MIN_VALUE;
        for(int i = 0;i<len;++i){
            min = i;
            for(int j = i;j<len;++j){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }
}
