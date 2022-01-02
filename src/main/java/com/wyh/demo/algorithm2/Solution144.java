package com.wyh.demo.algorithm2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/28 6:25 下午
 * LeetCode144 二叉树的前序遍历
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public void dfs(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }
}
