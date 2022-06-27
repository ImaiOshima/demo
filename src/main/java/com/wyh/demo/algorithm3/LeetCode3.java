package com.wyh.demo.algorithm3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname LeetCode3
 * @Description TODO
 * @Date 2022/6/21 23:27
 * @Created by 61635
 * 思路 滑动窗口
 * 用map记录窗口所有值和index 左右指针当成边界
 * 当右边界包含在map中时 左边界比较大小（基本上就是map的index的值 因为当前窗口是不可能有重复值的）
 * 然后更新值 把当前的map中
 * 进行之前的max比较
 */
public class LeetCode3 {
    HashMap<Character,Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int left = 0;
    public int lengthOfLongestSubstring(String s) {
        //入参check
        if(s.length() == 0 || s == null){
            return left;
        }
        //滑动窗口
        for(int i = 0;i < s.length();i++){
            char value = s.charAt(i);
            //check 包含进行左边界的大小比较
            if(map.containsKey(value)){
                //compare
                left = Math.max(left,map.get(value)+1);
            }
            //更新map
            map.put(value,i);
            //每次 进行右边界减去左边界 每次循环比较
            max = Math.max(i - left + 1,max);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode3 code = new LeetCode3();
        String s = "abcabcbb";
        int maxLen = code.lengthOfLongestSubstring(s);
    }
}
