package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/24 5:38 下午 LeetCode 字符串相加 https://leetcode-cn.com/problems/add-strings/
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1,j = num2.length() - 1 ,pic = 0;
        while (i >=0 || j >= 0) {
            int v1 = i < 0 ? 0:num1.charAt(i) - '0';
            int v2 = j < 0 ? 0:num2.charAt(j) - '0';
            int sum = v1 + v2 + pic;
            pic = sum / 10;
            res.append(sum%10);
            i--;
            j--;
        }
        if(pic > 0){
            res.append(pic);
        }
        return res.reverse().toString();
    }
}
