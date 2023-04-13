package com.wyh.demo.sort;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/3/16 8:48 下午
 * 希尓排序
 * 始终在数组中找到最大值 往后移动
 * 时间复杂n2
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(shellSort(arr)).forEach(x-> System.out.println(x));
    }

    public static int[] shellSort(int[] arr){
        int len = arr.length;
        for(int gap = (int) Math.floor(len/2); gap>0; gap = (int)Math.floor(gap/2)){
            for(int i = gap;i<len;i++){
                int current = arr[i];
                int j = i - gap;
                while(j>=0 && current < arr[j]){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = current;
            }
        }
        return arr;
    }
}
