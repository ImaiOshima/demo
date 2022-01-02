package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/26 10:36 下午
 * 剑指offer 链表中倒数第k个节点
 */
public class Solution1000 {
    int count;
    public ListNode getKthFromEnd(ListNode head, int k) {
        // base
        if(head == null){
            return head;
        }
        ListNode dump = getKthFromEnd(head.next,k);
        count++;
        if(count == k){
            return head;
        }
        return dump;
    }
}
