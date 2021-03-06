package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode33
 * @Description TODO
 * @Date 2022/7/4 20:11
 * @Created by 61635
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(target <= nums[end] && target > nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
