package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode92
 * @Description TODO
 * @Date 2022/7/6 0:17
 * @Created by 61635
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        ListNode dump = new ListNode();
        dump.next = head;
        ListNode pre = dump;
        ListNode leftNode;
        ListNode after;
        ListNode rightNode = dump;
        for(int i = 0;i<left-1;i++){
            pre = pre.next;
        }
        for(int i = 0;i<right;i++){
            rightNode = rightNode.next;
        }
        leftNode = pre.next;
        after = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        ListNode v = reverse(leftNode);
        pre.next = v;
        leftNode.next = after;
        return dump.next;
    }

    public ListNode reverse(ListNode left){
        if(left == null || left.next == null){
            return left;
        }
        ListNode curr = reverse(left.next);
        left.next.next = left;
        left.next = null;
        return curr;
    }
}
