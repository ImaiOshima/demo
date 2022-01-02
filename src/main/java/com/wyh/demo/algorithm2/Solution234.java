package com.wyh.demo.algorithm2;

import java.util.Stack;

/**
 * @author imai
 * @since 2021/4/29 10:07 下午
 * LeetCode234 回文链表
 */
public class Solution234 {
    Stack<Integer> stack = new Stack<>();
    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        while(tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        while(!stack.isEmpty()){
            if(head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
