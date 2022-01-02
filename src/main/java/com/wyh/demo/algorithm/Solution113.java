package com.wyh.demo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author imai
 * @since 2021/1/31 8:20 下午
 *  LeetCode 路径总和||
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(root,sum,new ArrayList<Integer>(),result);
        return result;
    }

    public void dfs(TreeNode root,int sum,List<Integer> arr,List<List<Integer>> result){
        if(root == null){
            return;
        }
        arr.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            result.add(new ArrayList<>(arr));
            arr.remove(arr.size() - 1);
            return;
        }
        dfs(root.left,sum - root.val,arr,result);
        dfs(root.right,sum - root.val,arr,result);
        arr.remove(arr.size() - 1);
    }
}
