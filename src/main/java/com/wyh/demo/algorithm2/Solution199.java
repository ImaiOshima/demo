package com.wyh.demo.algorithm2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/26 11:25 下午
 * LeetCode99 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Solution199 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    /**
     * 终点就是只有左子树比右子树深度高的时候才能加到数组中
     * @param root
     * @param depth
     */
    public void dfs(TreeNode root,int depth){
        if(root == null){
            return;
        }
        depth++;
        if(depth > ans.size()){
            ans.add(root.val);
        }
        dfs(root.right,depth);
        dfs(root.left,depth);
    }

}
