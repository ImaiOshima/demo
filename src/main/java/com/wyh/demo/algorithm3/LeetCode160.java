package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode160
 * @Description TODO
 * @Date 2022/7/5 14:50
 * @Created by 61635
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode up = headA;
        ListNode down = headB;
        while(up != down){
            if(up == null){
                up = headB;
            }else{
                up = up.next;
            }
            if(down == null){
                down = headA;
            }else{
                down = down.next;
            }
        }
        return up;
    }
}
