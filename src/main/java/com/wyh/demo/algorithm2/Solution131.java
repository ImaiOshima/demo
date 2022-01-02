package com.wyh.demo.algorithm2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author imai
 * @since 2021/5/7 10:58 下午
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s.length() == 0) {
            return ans;
        }
        char[] c = s.toCharArray();
        Deque<String> deque = new LinkedList<>();
        dfs(ans, deque, c, 0, s.length());
        return ans;
    }

    /**
     * 回溯
     * @param ans
     * @param deque
     * @param c
     * @param index
     * @param len
     */
    public void dfs(List<List<String>> ans, Deque<String> deque, char[] c, int index, int len) {
        if (index == len) {
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!checkValue(c, index, i) ) {
                continue;
            }
            deque.add(new String(c, index, i + 1 - index));
            dfs(ans, deque, c, i + 1, len);
            deque.removeLast();
        }
    }

    /**
     * 判断当前字符串是否是回文串
     * @param c
     * @param left
     * @param right
     * @return
     */
    public boolean checkValue(char[] c, int left, int right) {
        while (left < right) {
            if (c[left] != c[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
