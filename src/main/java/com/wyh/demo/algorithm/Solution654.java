package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/4/11 3:08 下午
 * Leetcode 最大二叉树
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursive(nums,0,nums.length-1);
    }

    public TreeNode recursive(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        //拿到当前数组的最大值下标
        int maxIndex = getMaxValueIndex(nums,start,end);
        //根据最大值创建节点
        TreeNode node = new TreeNode(nums[maxIndex]);
        //左子树再根据最大值的下标来进行递归
        TreeNode left = recursive(nums,start,maxIndex-1);
        //右子树再根据最大值进行递归
        TreeNode right = recursive(nums,maxIndex+1,end);
        node.left = left;
        node.right = right;
        return node;
    }

    public int getMaxValueIndex(int[] nums,int start,int end){
        int maxIndex = start;
        for(int i = start+1;i<=end;i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
