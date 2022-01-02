package com.wyh.demo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author imai
 * @since 2021/4/13 11:13 下午
 */
public class Solution652 {

    HashMap<String,Integer> hashMap = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return list;
    }

    public String find(TreeNode root){
        if(root == null){
            return "$";
        }
        String left = find(root.left);
        String right = find(root.right);
        String name = left + "#" + right + "#" + root.val;

        int freq = hashMap.getOrDefault(name,0);
        if(freq == 1){
            list.add(root);
        }

        hashMap.put(name,freq+1);
        return name;
    }
}
