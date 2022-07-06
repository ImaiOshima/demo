package com.wyh.demo.algorithm3;

import java.util.List;

/**
 * @Classname LeetCode23
 * @Description TODO
 * @Date 2022/7/5 16:17
 * @Created by 61635
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int index = lists.length - 1;
        return merge(lists,0,index);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
        if(left == right){return lists[left];}
        int mid = left + (right - left)/2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return dfs(l1,l2);
    }

    public ListNode dfs(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = dfs(l1.next,l2);
            return l1;
        }else{
            l2.next = dfs(l2.next,l1);
            return l2;
        }
    }
}
