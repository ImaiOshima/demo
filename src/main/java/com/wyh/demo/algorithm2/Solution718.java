package com.wyh.demo.algorithm2;

/**
 * @author imai
 * @since 2021/4/28 5:21 下午
 * LeetCode718 最长重复子数组
 */
public class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int max = 0;
        for(int i = 0;i<len1;i++){
            int len = Math.min(len2,len1-i);
            int ret = compare(nums1,nums2,i,0,len);
            max = Math.max(ret,max);
        }

        for(int i = 0;i<len2;i++){
            int len = Math.min(len2 - i,len1);
            int ret = compare(nums1,nums2,0,i,len);
            max = Math.max(ret,max);
        }

        return max;
    }

    public int compare(int[] A,int[] B,int l,int r,int len){
        int ret = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (A[l + i] == B[r + i]) {
                ret++;
            }else{
                ret = 0;
            }
            max = Math.max(max,ret);
        }
        return max;
    }
}
