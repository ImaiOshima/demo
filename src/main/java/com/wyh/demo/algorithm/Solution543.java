package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/1/31 8:20 下午
 *  LeetCode 二叉树的直径
 */
public class Solution543 {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max= Math.max(max,left+right);
        return max;
    }
}
