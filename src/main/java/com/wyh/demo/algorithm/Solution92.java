package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/1/31 8:20 下午
 *  LeetCode 反转链表\\
 */
public class Solution92 {
    ListNode superCall = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1){
            return reverseN(head,n);
        }
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }

    public ListNode reverseN(ListNode head,int end){
        if(end == 1){
            superCall = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, end -1);
        head.next.next = head;
        head.next = superCall;
        return last;
    }
}
