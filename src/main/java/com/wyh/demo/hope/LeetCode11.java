package com.wyh.demo.hope;

import io.reactivex.rxjava3.core.Single;

/**
 * @author imai
 * @since 2022/8/31 5:27 下午
 * 盛最多水的容器
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            max = height[l] < height[r] ?
                Math.max(max, (r - l) * height[l++]) :
                Math.max(max, (r - l) * height[r--]);
        }
        return max;
    }
}
