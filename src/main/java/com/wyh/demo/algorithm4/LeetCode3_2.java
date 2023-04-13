package com.wyh.demo.algorithm4;

import java.util.HashMap;

/**
 * @Classname LeetCode3_2
 * @Description TODO
 * @Author Imai
 * @Date 2023/1/12 23:58
 * @Created by 61635
 */
public class LeetCode3_2 {
    HashMap<Character,Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int left = 0;
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.min(left,map.get(c));
            }
            max = Math.max(max,i-left+1);
            map.put(c,i);
        }
        return max;
    }
}
