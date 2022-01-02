package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/2/27 11:46 下午 leetCode 零钱兑换 从上到下递归
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int memo[] = new int[amount + 1];
        memo[0] = 0;
        for(int i = 1;i<=amount;++i){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<coins.length;++j){
                if(i-coins[j]>=0 && memo[i-coins[j]] < min){
                    min = memo[i-coins[j]] + 1;
                }
            }
            memo[i] = min;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1:memo[amount] ;
    }
}
