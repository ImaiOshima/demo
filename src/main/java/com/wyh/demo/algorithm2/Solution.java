package com.wyh.demo.algorithm2;
/**
 * @author imai
 * @since 2021/4/23 8:53 下午
 * LeetCode 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Solution {
    public int maxSubArray(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int num:nums){
            //最重要的一个前提 就是题目是要求连续的子数组的最大值
            //如果sum大于0表示之前相加的都是正数 毕竟是求最大值 所以保留 小于代表之前都可以抛弃掉了
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}