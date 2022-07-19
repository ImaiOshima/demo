package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode124
 * @Description TODO
 * @Date 2022/7/6 15:18
 * @Created by 61635
 */
public class LeetCode124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //递归左子树
        int left = dfs(node.left);
        //递归右子树
        int right = dfs(node.right);
        //算出左子树 还是 右子树 还是 自己返回比较好 进行返回
        int count = Math.max(node.val, node.val + Math.max(left, right));
        // 比较大小 不想上递归 直接加上
        max = Math.max(max, Math.max(count, node.val + left + right));
        return count;
    }
}
