package com.wyh.demo.hope;

/**
 * @Classname LeetCode206
 * @Description TODO
 * @Date 2022/9/25 23:12
 * @Created by 61635
 * 反转链表
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
