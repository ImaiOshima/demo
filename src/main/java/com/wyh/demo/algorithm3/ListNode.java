package com.wyh.demo.algorithm3;

/**
 * @author imai
 * @since 2021/1/14 10:15 下午
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
