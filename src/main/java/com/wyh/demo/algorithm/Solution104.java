package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/1/31 8:20 下午
 *  LeetCode 二叉树的最大深度
 */
public class Solution104 {
    int max;
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
