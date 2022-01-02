package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/2/21 10:03 下午
 * Leetcode124 二叉树中的最大路径和
 */
public class Solution124 {
    int res = Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + right + left);
        return root.val + Math.max(right, left);
    }
}
