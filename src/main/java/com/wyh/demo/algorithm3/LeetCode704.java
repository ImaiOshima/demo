package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode704
 * @Description TODO
 * @Date 2022/7/7 9:04
 * @Created by 61635
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
