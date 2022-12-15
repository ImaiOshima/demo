package com.wyh.demo.algorithm4;

import java.util.HashMap;

/**
 * @Classname LeetCode3
 * @Description TODO
 * @Author Imai
 * @Date 2022/11/17 22:55
 * @Created by 61635 无重复字符的最长子串
 */
public class LeetCode3 {
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0;
    int max = 0;
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return left;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                //难点:解决abcb的情况下 当循环下来之后到第二个b之后 判断map中有字符串
                //比较当前left和当前map中value的左边的位置地址 进行相互比较
                left = Math.max(left,map.get(c)+1);
            }
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }
}
