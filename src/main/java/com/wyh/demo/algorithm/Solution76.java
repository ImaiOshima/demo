package com.wyh.demo.algorithm;

import java.util.HashMap;

/**
 * @author imai
 * @since 2021/2/2 9:19 下午
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int left = 0;
        int start = 0, length = Integer.MAX_VALUE;
        int valid = 0;
        char[] sCharList = s.toCharArray();
        char[] tCharList = t.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : tCharList) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < sCharList.length; ++right) {
            char v = sCharList[right];
            if (map.containsKey(v)) {
                window.put(v, window.getOrDefault(v, 0) + 1);
                if (window.get(v).equals(map.get(v))) {
                    valid++;
                }
            }

            if (valid == map.size()) {
                if (right + 1 - left < length) {
                    start = left;
                    length = right + 1 - left;
                }

                char c1 = s.charAt(left);
                left++;

                if (map.containsKey(c1)) {
                    if (window.get(c1).equals(map.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
