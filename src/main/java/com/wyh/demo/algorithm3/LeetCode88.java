package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode88
 * @Description TODO
 * @Date 2022/7/5 11:20
 * @Created by 61635
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m -1;
        int len2 = n -1;
        int len = m + n -1;
        while(len1>=0 && len2>=0){
            nums1[len--] = nums1[len1--] > nums2[len2--] ? nums1[len1]:nums2[len2];
        }
        System.arraycopy(nums2,0,nums1,0,len2+1);
    }
}
