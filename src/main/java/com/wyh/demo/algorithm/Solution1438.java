package com.wyh.demo.algorithm;

import java.util.TreeMap;

/**
 * @author imai
 * @since 2021/2/22 12:02 上午 leetCode 绝对差不超过限制的最长连续子数组
 */
public class Solution1438 {
    public static void main(String[] args) {
        int[] v = new int[]{10,1,2,4,7,2};
        System.out.println(longestSubarray(v,4));
    }
    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        //双指针 左右指针
        int left = 0;
        int right = 0;
        int max = 0;
        // 当互动窗口的最大值-最小值是 left++
        while(right < nums.length){
            map.put(right,nums[right]);
            if(Math.abs(map.get(map.lastKey()) - map.get(map.firstKey()))> limit){
                map.remove(nums[left]);
                left++;
            }
            max = Math.max(max,right - left);
            right++;
        }
        return max;
    }
}
