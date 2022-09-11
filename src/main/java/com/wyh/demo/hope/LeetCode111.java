package com.wyh.demo.hope;

/**
 * @Classname LeetCode111
 * @Description TODO
 * @Date 2022/9/4 15:41
 * @Created by 61635
 * 二叉树的最小深度
 */
public class LeetCode111 {
    //int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        int min = dfs(root);
        return min;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int min = Math.min(left,right);
        return min + 1;
    }
}


