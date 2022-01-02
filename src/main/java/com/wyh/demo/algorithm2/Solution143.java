package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/5/1 12:50 下午
 * LeetCode143 重排链表
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        // 这个说明这个链表只有两个节点
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        //快慢链表来拿到中点位置
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //拿到中间位置的节点
        //下半部部分节点
        ListNode reNode = slow.next;
        slow.next = null;
        ListNode dump = reverseList(reNode);
        //把两个链表结合在一起
        while(dump != null){
            ListNode tmp = head.next;
            ListNode tmp2 = dump.next;
            head.next = dump;
            dump.next = tmp;
            head = tmp;
            dump = tmp2;
        }
    }

    /**
     * 递归实现链表反转
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }
}
