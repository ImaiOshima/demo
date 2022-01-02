package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/23 12:37 上午
 * LeetCode 反转链表  简单
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }
        ListNode curr = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }
}
