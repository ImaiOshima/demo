package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/25 9:17 下午
 * LeetCode5 最长回文子串
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        int len = s.length();
        int start = 0;
        int end = 0;

        for(int i = 0;i<len;i++){
            int len1 = getEveryLength(s,i,i,len);
            int len2 = getEveryLength(s,i,i+1,len);
            int lenMax = Math.max(len1,len2);
            if(lenMax > end - start){
                //end - start 要保持lenMax的长度
                start = i - (lenMax-1)/2;
                end = i + lenMax/2 + 1;
            }
        }
        //小心醉最后一个数值是不包括的 所以要加上一个才行。
        return s.substring(start,end);
    }

    public int getEveryLength(String s,int left,int right,int len){
        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        //这里一定是-1 为什么 我传过来的right+1 成立s.charAt(left) != s.charAt(right) 那长度就是0
        return right - left - 1;
    }
}
