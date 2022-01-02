package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/2/1 5:08 下午
 * LeetCode 平衡二叉树
 */
public class Solution110 {
    int max;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left =  dfs(root.left);
        max = 0;
        int right = dfs(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
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
