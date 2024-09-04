package com.wyh.demo.sort;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/3/16 8:48 下午
 * 冒泡排序
 * 始终在数组中找到最大值 往后移动
 * 时间复杂n2
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(bubbleSort(arr)).forEach(x-> System.out.println(x));
    }

    // 加上falg 可以减少循坏
    public static int[] bubbleSort(int[] arr){
        int len = arr.length;
        // 这份for主要是为了 因为最大值放到了 最后不用在比较 直接减少范围
        for(int i = 0; i <= len-1; i++){
            boolean flag = true;
            for(int j = 0; j + 1 < len-i; j++){
                // 在这个循环中比较大小 进行最大值放大最后
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        return arr;
    }
}
