package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/24 5:17 下午
 * LeetCode 买卖股票的最佳时机
 */
public class Solution121 {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public int maxProfit(int[] prices) {
        for(int price:prices){
            min = Math.min(price,min);
            max = Math.max(max,price - min);
        }
        return max;
    }
}
