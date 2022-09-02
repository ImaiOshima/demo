package com.wyh.demo.hope;

/**
 * @author imai
 * @since 2022/9/1 9:36 上午
 * 跳跃游戏
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int len = nums.length;
        int maxPosition = 0;
        int end = 0;
        int step = 0;
        for(int i = 0;i < len;i++){
            maxPosition = Math.max(maxPosition,nums[i]+i);
            if(i >= end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
