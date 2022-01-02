package com.wyh.demo.algorithm2;

import java.util.HashMap;

/**
 * @author imai
 * @since 2021/4/24 4:00 下午 LeetCode 两数之和 https://leetcode-cn.com/problems/two-sum/
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap(len);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
