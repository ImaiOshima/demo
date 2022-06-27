package com.wyh.demo.sort;

import com.wyh.demo.test.A;

import java.util.Arrays;

/**
 * @Classname MergeSort
 * @Description TODO
 * @Date 2022/6/27 9:35
 * @Created by 61635
 * 归并排序
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,8,0};
        Arrays.stream(sort(arr)).forEach(x-> System.out.println(x));
    }

    //数组大小小于一时 结束分组
    public static int[] sort(int[] arr){
        int len = arr.length;
        if(len < 2){
            return arr;
        }
        int middle = (int)Math.floor(len/2);
        int[] left = Arrays.copyOfRange(arr,0,middle);
        int[] right = Arrays.copyOfRange(arr,middle,len);
        return merge(sort(left),sort(right));
    }

    //两根指针 对刷。
    public static int[] merge(int[] left,int[] right){
         int[] result = new int[left.length+right.length];
         int i = 0;
         while(left.length >0 && right.length >0){
             if(left[0] < right[0]){
                 result[i++] = left[0];
                 left = Arrays.copyOfRange(left,1,left.length);
             }else{
                 result[i++] = right[0];
                 right = Arrays.copyOfRange(right,1,right.length);
             }
         }
         while(left.length > 0){
             result[i++] = left[0];
             left = Arrays.copyOfRange(left,1,left.length);
         }
         while(right.length > 0){
             result[i++] = right[0];
             right = Arrays.copyOfRange(right,1,right.length);
         }
         return result;
    }
}
