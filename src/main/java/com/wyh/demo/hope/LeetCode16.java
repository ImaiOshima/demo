package com.wyh.demo.hope;

import java.util.Arrays;

/**
 * @Classname LeetCode16
 * @Description TODO
 * @Date 2022/9/12 23:52
 * @Created by 61635
 * 最接近的三数之和
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for(int i = 0;i<len;i++){
            int start = i + 1;
            int end = len - 1;
            int val;
            while(start < end){
                val = nums[i] + nums[start] + nums[end];
                if(Math.abs(target - ans) > Math.abs(target - val)){
                    ans = val;
                }
                if(val > target){
                    end--;
                }else if(val < target){
                    start++;
                }else{
                    return ans;
                }
            }
        }
        return ans;
    }
}
