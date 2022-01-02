package com.wyh.demo.algorithm2;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/4/27 12:07 上午
 * LeetCode300 最长递增子序列
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //算出每个点的最大值 然后拿出其中的最大值
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                   dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
