package com.wyh.demo.sort;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/3/16 9:02 下午
 * 选择排序
 * 每次j循环找到数组中最小的值
 * 于i循环的值进行替换 如果两个位置一样 就不用替换
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(selectionSort(arr)).forEach(x-> System.out.println(x));
    }

    public static int[] selectionSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i <= len - 1; i++){
            int minIndex = i;
            for(int j = i; j<=len -1;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }
}
