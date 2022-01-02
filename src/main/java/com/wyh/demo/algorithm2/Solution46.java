package com.wyh.demo.algorithm2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/25 8:12 下午
 * LeetCode46 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,ans,list);
        return ans;
    }

    public void dfs(int[] nums,List<List<Integer>> ans,List<Integer> list){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        //每次判断数组中哪一个值没被添加到list中
        //从1为第一位开始 然后变换下面两位
        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums,ans,list);
            list.remove(list.size() - 1);
        }
    }
}
