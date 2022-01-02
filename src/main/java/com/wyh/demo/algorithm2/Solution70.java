package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/27 12:47 上午
 * LeetCode70 爬楼梯
 */
public class Solution70 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n+1];
    }
}
