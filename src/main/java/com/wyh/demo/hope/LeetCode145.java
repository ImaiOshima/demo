package com.wyh.demo.hope;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LeetCode145
 * @Description TODO
 * @Date 2022/9/7 22:57
 * @Created by 61635
 * 后续遍历
 */
public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public void dfs(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        dfs(root.left,ans);
        dfs(root.right,ans);
        ans.add(root.val);
    }
}
