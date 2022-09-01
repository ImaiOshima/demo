package com.wyh.demo.hope;

/**
 * @author imai
 * @since 2022/8/31 11:17 上午
 * 最长回文串
 */
public class LeetCode5 {
    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1){
            return s;
        }
        int strLen = s.length();
        int maxLen = 0;
        int start = 0;
        int end = 0;
        // 二维数组 进行缓存判断 默认为false
        boolean[][] dp = new boolean[strLen][strLen];
        for(int r = 1;r<strLen;r++){
            for(int l = 0;l < r;l++){
                if(s.charAt(l) == s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l+1 > maxLen){
                        maxLen = r-l+1;
                        start=l;
                        end=r;
                    }
                }
            }
        }
        //左闭右开
        return s.substring(start,end+1);
    }
}
