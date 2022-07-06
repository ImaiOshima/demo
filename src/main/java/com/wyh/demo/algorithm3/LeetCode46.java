package com.wyh.demo.algorithm3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LeetCode46
 * @Description TODO
 * @Date 2022/7/5 15:21
 * @Created by 61635
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(res,nums,new ArrayList<Integer>(),visited);
        return res;
    }

    public void dfs(List<List<Integer>> res,int[] nums,List<Integer> tmp,int[] visited){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(visited[i] == 1){continue;}
            visited[i] = 1;
            tmp.add(nums[i]);
            dfs(res,nums,tmp,visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
