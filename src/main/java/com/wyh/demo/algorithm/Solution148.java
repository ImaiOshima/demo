package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/3/10 1:13 上午
 * leetCode 排序链表
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        ListNode low = head;
        ListNode high = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        return head;
    }
}
