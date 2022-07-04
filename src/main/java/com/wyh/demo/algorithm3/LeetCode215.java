package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode215
 * @Description TODO
 * @Date 2022/6/26 11:23
 * @Created by 61635
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        buildHeap(nums,len);
        for(int i = len-1;i>nums.length-k;i--){
            swap(nums,0,i);
            len--;
            headify(nums,0,len);
        }
        return nums[0];
    }

    public static void buildHeap(int[] nums,int len){
        for(int i = (int)Math.floor(len/2) - 1;i>=0;i--){
            headify(nums,i,len);
        }
    }

    public static void headify(int[] nums,int i,int len){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;
        if(left < len && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < len && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            swap(nums,i,largest);
            headify(nums,largest,len);
        }
    }

    public static void swap(int[] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
