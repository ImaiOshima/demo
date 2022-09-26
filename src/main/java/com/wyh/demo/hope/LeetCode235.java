package com.wyh.demo.hope;

/**
 * @Classname LeetCode235
 * @Description TODO
 * @Date 2022/9/11 21:14
 * @Created by 61635
 * 二叉搜索树的最近公共祖先
 */
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while((root.val - p.val) * (root.val - q.val) > 0){
            root = (root.val - p.val) > 0 ? root.left:root.right;
        }
        return root;
    }
}
