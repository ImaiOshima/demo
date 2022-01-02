package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/4/15 12:05 上午
 * LeetCode 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class Solution230 {

    int count,res;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }

    public void inorder(TreeNode root,int k){
        if(root == null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count == k){
            res = root.val;
            return;
        }
        inorder(root.right,k);
    }
}
