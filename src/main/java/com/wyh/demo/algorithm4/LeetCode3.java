package com.wyh.demo.algorithm4;

import org.redisson.misc.Hash;

import java.util.HashMap;

/**
 * @Classname LeetCode3
 * @Description TODO
 * @Author Imai
 * @Date 2024/09/20 18:48
 * @Created by 61635 无重复字符的最长子串
 */
public class LeetCode3 {


    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s == null || s.length() == 0){
            return max;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        for(int i = 0;i < s.length();i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                //
                left = Math.max(left,map.get(c) + 1);
            }
            max = Math.max(max,i - left + 1);
            map.put(c,i);
        }
        return max;
    }
}
