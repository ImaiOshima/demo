package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/23 10:03 下午
 * LeetCode K个一组反转链表
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<0 || head == null){
            return head;
        }
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = dump;
        ListNode next = dump;

        ListNode start = head;
        ListNode end = head;
        while(end != null){
            for(int i = 0;i<k-1 && end != null;i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            start = next;
            end = next;
        }
        return dump.next;
    }

    /**
     * 递归链表
     * @param node
     * @return
     */
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode curr = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return curr;
    }
}
