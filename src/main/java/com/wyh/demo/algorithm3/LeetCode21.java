package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode21
 * @Description TODO
 * @Date 2022/7/4 14:03
 * @Created by 61635
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
