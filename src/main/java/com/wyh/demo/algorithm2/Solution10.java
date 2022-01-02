package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/28 7:44 下午
 * LeetCode110 平衡二叉树
 */
public class Solution10 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        if(left == -1) return -1;
        int right = dfs(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
