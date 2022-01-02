package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/1/31 8:20 下午
 *  LeetCode 最大子序和
 */
public class Solution53 {
    public int maxSubArray(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num: nums){
            if(sum>0){
                sum += num;
            }else{
                sum = num;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
