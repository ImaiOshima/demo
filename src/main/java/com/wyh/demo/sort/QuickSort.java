package com.wyh.demo.sort;

import java.util.Arrays;

/**
 * @Classname Quick
 * @Description TODO
 * @Date 2022/6/27 11:11
 * @Created by 61635
 * 快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        int len = arr.length;
        Arrays.stream(sort(arr,0,len-1)).forEach(x-> System.out.println(x));
    }

    public static int[] sort(int[] arr,int left,int right){
        if(left < right){
            int partitionIndex = partition(arr,left,right);
            sort(arr,left,partitionIndex - 1);
            sort(arr,partitionIndex+1,right);
        }
        return arr;
    }

    public static int partition(int[] arr,int left,int right){
        int pivot = left;
        int index = pivot + 1;
        // 以left为基础 分成大于arr[left]和小于arr[left] 两部分
        for(int i = left + 1;i<=right;i++){
            if(arr[i] < arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        // 因为上面小于时 进行了++ 所以现在的arr[index]是大于arr[left]的 所以进行index-- 然后进行替换
        swap(arr,pivot,index - 1);
        return index-1;
    }

    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
