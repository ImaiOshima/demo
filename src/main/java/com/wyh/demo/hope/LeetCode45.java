package com.wyh.demo.hope;

/**
 * @author imai
 * @since 2022/9/1 9:36 上午
 * 跳跃游戏
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        // 总体逻辑就是找到每个位置能达到的最大值
        // 但是nums[0]肯定得经过 所以第一个边界是固定
        // 在第一个边界当中寻找最大边界 超过边界就+1 就能算出step数
        int len = nums.length;
        int maxPosition = 0;
        int end = 0;
        int step = 0;
        // 小于 len - 1 非常重要 因为如果end刚好在len-1上 那step就会加上1
        // len - 2都能过得话 可能说明len-1肯定是能过去的。
        for(int i = 0;i < len - 1;i++){
            // 记录当前最大的边界值
            maxPosition = Math.max(maxPosition,nums[i]+i);
            if(i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
