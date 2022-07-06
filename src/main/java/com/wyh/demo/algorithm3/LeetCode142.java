package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode142
 * @Description TODO
 * @Date 2022/7/5 22:49
 * @Created by 61635
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null){
            if(fast == slow){
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
