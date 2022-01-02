package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/5/2 7:02 下午
 * LeetCode226 翻转二叉树
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        TreeNode left = root.right;
        TreeNode right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
