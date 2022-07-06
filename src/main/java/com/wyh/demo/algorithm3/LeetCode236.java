package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode236
 * @Description TODO
 * @Date 2022/7/5 9:39
 * @Created by 61635
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null) {return null;}
        if(left == null){return right;}
        if(right == null){return left;}
        return root;
    }
}
