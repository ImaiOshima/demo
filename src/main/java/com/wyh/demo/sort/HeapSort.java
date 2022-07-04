package com.wyh.demo.sort;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/3/16 8:48 下午
 * 冒泡排序
 * 始终在数组中找到最大值 往后移动
 * 时间复杂n2
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(heapSort(arr)).forEach(x-> System.out.println(x));
    }

    public static int[] heapSort(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        int len = arr.length;
        buildHeap(arr,len);
        for(int i = len -1;i>0;i--){
            swap(arr,0,i);
            len--;
            headify(arr,0,len);
        }
        return arr;
    }

    public static void buildHeap(int[] arr,int len){
        for(int i = (int)Math.floor(len/2) - 1;i>=0;i--){
            headify(arr,i,len);
        }
    }

    public static void headify(int[] arr,int i,int len){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;
        if(left < len && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < len && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            swap(arr,i,largest);
            headify(arr,largest,len);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
