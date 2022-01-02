package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/2/21 11:29 下午
 * LeetCode 买卖股票的最佳时机
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int index = 1;
        int min = Integer.MAX_VALUE;
        int moneyMax = 0;
        while(index < prices.length){
            min = Math.min(min,prices[index - 1]);
            moneyMax = Math.max(moneyMax,prices[index] - min);
            index++;
        }
        return moneyMax;
    }
}
