package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/4/11 4:12 下午 Leetcode105 从前序与中序遍历序列构造二叉树
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if(p_start == p_end ){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int index = 0;
        //拿到中序遍历中 root 的位置
        for(int i = i_start;i<i_end;i++){
            if(inorder[i] == preorder[p_start]){
                index = i;
                break;
            }
        }
        int leftNum = index - i_start;
        root.left = buildTreeHelper(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,index);
        root.right = buildTreeHelper(preorder,p_start+leftNum+1,p_end,inorder,index+1,i_end);
        return root;
    }
}
