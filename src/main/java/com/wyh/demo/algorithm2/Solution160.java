package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/24 4:27 下午
 * LeetCode 相交链表
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA,pB = headB;
        while(pA != pB){
            pA = pA == null ? headB:pA.next;
            pB = pB == null ? headA:pB.next;
        }
        return pA;
    }
}
