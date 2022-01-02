package com.wyh.demo.algorithm2;

import java.util.Arrays;

/**
 * @author imai
 * @since 2021/4/29 11:41 下午
 * LeetCode56 合并区间
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int[][] ans = new int[intervals.length][2];
        int index = -1;
        for(int[] interval:intervals){
            if(index == -1){
                ans[++index] = interval;
                continue;
            }
            if(ans[index][1] < interval[0]){
                ans[++index] = interval;
            }else{
                ans[index][1] = Math.max(ans[index][1],interval[1]);
            }
        }
        return Arrays.copyOf(ans,index+1);
  }
}
