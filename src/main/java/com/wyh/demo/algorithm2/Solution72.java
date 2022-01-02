package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/5/3 12:57 下午 LeetCode72 编辑距离
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int j = 0; j < m; j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= n; i++) {
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
