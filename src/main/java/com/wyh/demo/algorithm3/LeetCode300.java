package com.wyh.demo.algorithm3;

import java.util.Arrays;

/**
 * @Classname LeetCode300
 * @Description TODO
 * @Date 2022/7/6 11:13
 * @Created by 61635
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i=0;i<len;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
