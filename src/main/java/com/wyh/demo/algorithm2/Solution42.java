package com.wyh.demo.algorithm2;

import java.util.Stack;

/**
 * @author imai
 * @since 2021/4/27 9:07 下午
 * LeetCode 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Solution42 {
    public int trap(int[] height) {
        int len = height.length;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<len;i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {

            }
            stack.push(i);
        }
        return count;
    }
}
