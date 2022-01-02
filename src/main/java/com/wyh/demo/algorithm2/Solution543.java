package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/30 12:08 上午
 * LeetCode543
 */
public class Solution543 {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max,right + left + 1);
        return Math.max(left,right) + 1;
    }
}
