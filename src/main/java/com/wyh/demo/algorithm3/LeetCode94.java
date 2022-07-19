package com.wyh.demo.algorithm3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LeetCode
 * @Description TODO
 * @Date 2022/7/7 9:59
 * @Created by 61635
 * 二叉树的中序遍历
 */
public class LeetCode94 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        dfs(root,res);
        return res;
    }

    public void dfs(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        dfs(node.left,res);
        res.add(node.val);
        dfs(node.right,res);
    }
}
