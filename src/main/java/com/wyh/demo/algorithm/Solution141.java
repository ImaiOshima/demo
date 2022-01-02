package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/1/31 8:20 下午
 *  LeetCode 环形链表
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if( head == null || head.next == null ){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
