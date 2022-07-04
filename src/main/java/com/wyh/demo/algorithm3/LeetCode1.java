package com.wyh.demo.algorithm3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Classname LeetCode1
 * @Description TODO
 * @Date 2022/7/4 14:19
 * @Created by 61635
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i<len;i++){
            int value = target - nums[i];
            if(hashMap.containsKey(value)){
                return new int[]{i,hashMap.get(value)};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
