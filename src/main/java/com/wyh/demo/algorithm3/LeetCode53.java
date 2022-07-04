package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode53
 * @Description TODO
 * @Date 2022/7/4 12:31
 * @Created by 61635
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        //比较大小的时候 先创建一个最小值 基本上没啥问题
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        //假设只有负数的情况下 肯定只能只有一个值 因为负数加负数跟小
        for(int num:nums){
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
