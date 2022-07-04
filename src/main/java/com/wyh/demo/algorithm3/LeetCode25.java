package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode25
 * @Description TODO
 * @Date 2022/7/3 22:45
 * @Created by 61635
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for(int i = 0;i<k;i++){
            if(tail == null){
                return head;
            }
            //如果k=2 tail就是第3个节点
            tail = tail.next;
        }
        ListNode newHead = reverse(head,tail);
        ListNode next = reverseKGroup(tail,k);
        head.next = next;
        return newHead;
    }

    public ListNode reverse(ListNode head,ListNode tail){
        ListNode pre = null;
        ListNode tmp = null;
        ListNode curr = head;
        while(curr != tail){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
