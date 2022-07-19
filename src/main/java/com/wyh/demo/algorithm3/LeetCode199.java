package com.wyh.demo.algorithm3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LeetCode199
 * @Description TODO
 * @Date 2022/7/7 10:58
 * @Created by 61635
 * 二叉树的右视图
 */
public class LeetCode199 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode node,int depth){
        if(node == null){
            return;
        }
        if(depth == res.size()){
            res.add(node.val);
        }
        depth++;
        dfs(node.right,depth);
        dfs(node.left,depth);
    }
}
