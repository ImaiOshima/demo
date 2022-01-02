package com.wyh.demo.algorithm2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/29 8:56 下午
 * LeetCode113 路径总和2
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Solution113 {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> q = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return ans;
    }

    public void dfs(TreeNode root,int target){
        if(root == null){
            return;
        }
        int v = target - root.val;
        q.offerLast(root.val);
        if(root.left == null && root.right == null && v == 0){
            ans.add(new LinkedList<>(q));
        }
        dfs(root.left,v);
        dfs(root.right,v);
        q.removeLast();
    }
}
