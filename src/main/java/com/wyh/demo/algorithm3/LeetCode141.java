package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode141
 * @Description TODO
 * @Date 2022/7/4 17:57
 * @Created by 61635
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while(right != null && right.next != null){
            if(left == right){
                return true;
            }
            left = left.next;
            right = right.next.next;
        }
        return false;
    }
}
