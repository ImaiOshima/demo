package com.wyh.demo.hope;

/**
 * @author imai
 * @since 2022/9/14 11:26 上午
 * 青蛙跳台阶问题
 */
public class Offer10 {
    public int numWays(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
