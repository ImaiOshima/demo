package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/27 11:32 下午
 * LeetCode 合并K个升序链表
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists,0,lists.length -1);
    }

    public ListNode merge(ListNode[] lists,int l,int r){
        if(l == r){
            return lists[l];
        }
        int mid = l + (r -l) / 2;
        ListNode l1 = merge(lists,l,mid);
        ListNode l2 = merge(lists,mid+1,r);
        return mergeTwoLists(l1,l2);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val > l2.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
}
