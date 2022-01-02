package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/28 2:06 下午
 * LeetCode104 二叉树的最大深度
 */
public class Solution104 {
    int max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(left,right);
        return max+1;
    }
}

