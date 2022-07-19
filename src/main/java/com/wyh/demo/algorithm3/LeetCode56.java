package com.wyh.demo.algorithm3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname LeetCode56
 * @Description TODO
 * @Date 2022/7/7 13:36
 * @Created by 61635
 * 合并区间
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals,(int[] v1,int[] v2) -> {return v1[0]-v2[0];});
        List<int[]> res = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            if(res.size() == 0 || res.get(res.size() -1)[1] < l ){
                res.add(new int[]{l,r});
            }else{
                res.get(res.size() - 1)[1] = Math.max( res.get(res.size() - 1)[1],r);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
