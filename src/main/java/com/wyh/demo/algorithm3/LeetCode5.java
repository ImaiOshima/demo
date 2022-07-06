package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode5
 * @Description TODO
 * @Date 2022/7/5 12:31
 * @Created by 61635
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0;
        int maxlen = Integer.MIN_VALUE;
        int nowLen = 1;
        int len = s.length();
        int left;
        int right;
        for(int i = 0;i<len;i++){
            left = i - 1;
            right = i + 1;
            char c = s.charAt(i);
            while(left >= 0 && c == s.charAt(left)){
                nowLen++;
                left--;
            }
            while(right < len && c == s.charAt(right)){
                nowLen++;
                right++;
            }
            while(left>=0&&right<len&& s.charAt(left) == s.charAt(right)){
                nowLen +=2;
                left--;
                right++;
            }
            if(nowLen > maxlen){
                maxlen = nowLen;
                start = left+1;
            }
            nowLen = 1;
        }
        return s.substring(start,start+maxlen);
    }
}
