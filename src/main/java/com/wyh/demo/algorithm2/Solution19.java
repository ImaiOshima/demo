package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/30 11:06 下午
 * LeetCode19 删除链表的倒数第N个结点
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            return null;
        }
        ListNode dump = new ListNode();
        dump.next = head;
        int i = 0;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dump;
        while(i<n){
            fast = fast.next;
            i++;
        }
        while(fast != null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return head;
    }
}
