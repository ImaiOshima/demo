package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/2/24 1:18 上午
 * LeetCode  翻转图像
 */
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int[] newArray = new int[A[0].length];
        for(int i = 0;i<A.length;++i){
            for(int j = 0;j<A[0].length;++j){
                newArray[j] = A[i][A[0].length - j - 1] == 0 ? 1:0;
                A[i] = newArray;
            }
        }
        return A;
    }
}
