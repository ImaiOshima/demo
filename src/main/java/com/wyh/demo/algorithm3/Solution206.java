package com.wyh.demo.algorithm3;

/**
 * @Classname Solution206
 * @Description TODO
 * @Date 2022/2/6 17:39
 * @Created by 61635
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution206 {
    //递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 递归循环 来实现
        // 递归循环到4的时候 开始递归返回 curr 为 node5
        ListNode curr = reverseList(head.next);
        // head 为 node4 开始为每个node 执行反转
        head.next.next = head;
        head.next = null;
        // 例如第一次 返回为 5->4
        return curr;
    }
    //迭代
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        if(curr!=null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
