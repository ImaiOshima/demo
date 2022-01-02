package com.wyh.demo.algorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/24 1:56 下午 LeetCode 三数之和 https://leetcode-cn.com/problems/3sum/
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // left 代表最后一个重复的元素的index
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // right 代表最前面一个重复元素的index
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 在加1代表就是不重复的第一个元素
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
