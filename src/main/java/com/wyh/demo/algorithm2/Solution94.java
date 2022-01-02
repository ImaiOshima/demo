package com.wyh.demo.algorithm2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/25 11:46 下午
 * LeetCode 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public void dfs(TreeNode root,List<Integer> ans){
        if(root == null || root == null){
            return;
        }
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);
    }
}
