package com.wyh.demo.hope;

import java.util.Stack;

/**
 * @author imai
 * @since 2022/9/1 3:19 下午
 * 接雨水
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int len = height.length;
        //单调栈 单调递减的单调栈
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int current = 0;
        //while 循环 进行stack插入
        while(current < len){
            // 当stack 不为空是进行判断 当前指针高度大于栈顶index的高度时 进行index的可以装入水的计算
            while(!stack.isEmpty() && (height[current] > height[stack.peek()])){
                int lh = height[stack.peek()];
                stack.pop();
                //推出栈顶的数据 之后stack 为空 就说明 她左边就没有高度了 说明水是不能装的 直接break掉 调到stack.push塞到栈中
                if(stack.isEmpty()){
                    break;
                }
                //距离计算
                int distance = current - stack.peek() - 1;
                //总的装入水分的值
                sum += distance * (Math.min(height[stack.peek()],height[current]) - lh);
            }
            //把当前指针塞到
            stack.push(current);
            current++;
        }
        return sum;
    }
}
