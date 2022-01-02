package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/24 1:07 下午
 * LeetCode 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val >= l2.val){
            //判断当前节点的数值大小
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
}
