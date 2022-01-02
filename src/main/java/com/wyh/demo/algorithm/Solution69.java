package com.wyh.demo.algorithm;

/**
 * @author imai
 * @since 2021/2/25 1:47 上午
 * LeetCode
 */
public class Solution69 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x + 1 / 2 ;
        while(left < right){
           long mid = (left + right) >>> 1;
           long square = mid * mid;
           if(square > x){
               right = mid - 1;
           }else{
               left = mid + 1;
           }
        }
        return (int)left;
    }
}
