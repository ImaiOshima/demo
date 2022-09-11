package com.wyh.demo.hope;

/**
 * @Classname LeetCode222
 * @Description TODO
 * @Date 2022/9/11 20:44
 * @Created by 61635
 * 完全二叉树的节点个数
 */
public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1<<left);
        }else{
            return countNodes(root.left) + (1<<right);
        }
    }

    public int countLevel(TreeNode node){
        int level = 0;
        while(node != null){
            level++;
            node = node.left;
        }
        return level;
    }
}
