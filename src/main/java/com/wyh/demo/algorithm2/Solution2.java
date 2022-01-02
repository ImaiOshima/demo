package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/27 10:18 下午 LeetCode2 两数相加
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode next = dump;
        int dep = 0;
        int sum = 0;
        int tmp = 0;
        while (l1 != null || l2 != null) {
            int l1v = 0;
            int l2v = 0;
            l1v = l1 == null ? 0:l1.val;
            l1 = l1 == null ? null : l1.next;
            l2v = l2 == null?0:l2.val;
            l2 = l2 == null ? null : l2.next;
            sum = l1v + l2v + dep;
            dep = sum / 10;
            tmp = sum % 10;
            ListNode node = new ListNode(tmp);
            next.next = node;
            next = node;
        }
        //有进位 只能是1 9+9 最多18
        if(dep == 1){
            next.next = new ListNode(dep);
        }
        return dump.next;
    }
}
