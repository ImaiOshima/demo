package com.wyh.demo.algorithm3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname LeetCode15
 * @Description TODO
 * @Date 2022/7/4 0:22
 * @Created by 61635
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i<len;i++){
            if(nums[i] > 0){
                return res;
            }
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1; int right = len - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(ans);
                    while( left < right && nums[left] == nums[left+1]){left++;}
                    while(left <right && nums[right] == nums[right-1]){right--;}
                    left++;
                    right--;
                }else if(nums[i] + nums[left] +nums[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}
