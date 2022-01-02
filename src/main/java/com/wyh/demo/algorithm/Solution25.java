package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/3/13 3:14 下午
 * K个 一组反转链表
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode a = head ,b = head;
        for(int i = 0;i<k;++i){
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    public ListNode reverse(ListNode a,ListNode b){
        ListNode cur = a ,next = a;
        ListNode pre = null;
        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

