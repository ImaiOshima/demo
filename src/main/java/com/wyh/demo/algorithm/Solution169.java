package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/2/27 11:30 下午
 * leetCode 多数元素
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int card_num = nums[0];
        int count = 1;
        for(int i = 0;i<nums.length;++i){
            if(card_num == nums[i]){
                count++;
            }else{
                count --;
            }
            if(count == 0){
                card_num = nums[i];
                count = 1;
            }
        }
        if(count > 0){
            return card_num;
        }else{
            return 0;
        }
    }
}
