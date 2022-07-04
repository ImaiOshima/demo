package com.wyh.demo.algorithm3;

import java.util.*;

/**
 * @Classname LeetCode103
 * @Description TODO
 * @Date 2022/7/4 18:47
 * @Created by 61635
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
         if(root == null){
             return res;
         }
         Deque<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         int count = 0;
         while(!queue.isEmpty()){
             LinkedList<Integer> arr = new LinkedList<>();
             int size = queue.size();
             for(int i = 0;i<size;i++){
                 TreeNode node = queue.poll();
                 if(node.left != null){
                     queue.add(node.left);
                 }
                 if(node.right != null){
                     queue.add(node.right);
                 }
                 if(count%2 == 0){
                     arr.add(node.val);
                 }else{
                     arr.addFirst(node.val);
                 }
             }
             res.add(arr);
             count++;
         }
         return res;
    }
}
