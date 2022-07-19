package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode70
 * @Description TODO
 * @Date 2022/7/7 14:39
 * @Created by 61635
 */
public class LeetCode70 {
    public int climbStairs(int n) {
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;
       for(int i =2;i<=n;i++){
           dp[i] = dp[i-1] + dp[i-2];
       }
       return dp[n];
    }
}
