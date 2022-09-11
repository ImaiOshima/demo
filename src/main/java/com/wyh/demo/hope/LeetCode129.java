package com.wyh.demo.hope;

/**
 * @Classname LeetCode129
 * @Description TODO
 * @Date 2022/9/4 16:57
 * @Created by 61635
 * 求根节点到叶节点数字之和
 */
public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root,int i){
        if(root == null){
            return 0;
        }
        int tmp = i * 10 + root.val;
        if(root.left == null && root.right == null){
            return tmp;
        }
        int left = dfs(root.left,tmp);
        int right = dfs(root.right,tmp);
        int sum = left + right;
        return sum;
    }
}
