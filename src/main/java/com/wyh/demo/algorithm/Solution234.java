package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/3/13 4:26 下午
 * 回文链表
 */
public class Solution234 {
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return reverse(head);
    }

    public boolean reverse(ListNode right){
        if(right == null){
            return true;
        }
        boolean res = reverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}
