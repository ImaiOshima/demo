package com.wyh.demo.algorithm3;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Classname LeetCode102
 * @Description TODO
 * @Date 2022/7/4 14:37
 * @Created by 61635
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arr = new ArrayList<>(size);
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                arr.add(node.val);
            }
            res.add(arr);
        }
        return res;
    }
}
