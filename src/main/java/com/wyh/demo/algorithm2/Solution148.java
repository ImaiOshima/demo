package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/5/1 10:56 下午
 * LeetCode148 排序链表
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next !=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dump = new ListNode();
        ListNode res = dump;
        while(left != null && right!=null){
            if(left.val > right.val){
                dump.next = right;
                right = right.next;
            }else{
                dump.next = left;
                left = left.next;
            }
            dump = dump.next;
        }
        dump.next = left != null ? left:right;
        return res.next;
    }
}
