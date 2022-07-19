package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode232
 * @Description TODO
 * @Date 2022/7/7 11:11
 * @Created by 61635
 * 用栈实现队列
 */
public class LeetCode232 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        while(n>0){
            end = end.next;
            n--;
        }
        while(end.next !=null){
            start = start.next;
            end = end.next;
        }
        //虽然我不知道这个为啥报错  但不得不说这个更安全
        //start.next = end;
        start.next = start.next.next;
        return pre.next;
    }
}
