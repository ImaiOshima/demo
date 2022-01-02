package com.wyh.demo.sort;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/3/16 8:48 下午
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(bubbleSort(arr)).forEach(x-> System.out.println(x));
    }

    public static int[] bubbleSort(int[] arr){
        int len = arr.length;
        for(int i = 0;i<len -1;++i){
            for(int j = 0;j<len-1-i;++j){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
}
