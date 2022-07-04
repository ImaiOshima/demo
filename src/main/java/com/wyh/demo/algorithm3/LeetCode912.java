package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode
 * @Description TODO
 * @Date 2022/7/3 23:20
 * @Created by 61635
 */
public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums,int left,int right){
        if(left < right){
            int partitionIndex = partition(nums,left,right);
            quickSort(nums,left,partitionIndex);
            quickSort(nums,partitionIndex+1,right);
        }
    }

    public int partition(int[] nums,int left,int right){
        int pivot = left;
        int index = pivot + 1;
        for(int i = index;i<=right;i++){
            if(nums[i] < nums[pivot]){
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,pivot,index-1);
        return index-1;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
