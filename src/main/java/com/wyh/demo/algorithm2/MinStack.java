package com.wyh.demo.algorithm2;

import java.util.Stack;

/**
 * @author imai
 * @since 2021/4/28 6:32 下午
 * LeetCode155 最小栈
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //保持最小栈只有一个数值 就是最小值
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int top = stack.pop();
            if(top == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        throw new RuntimeException("");
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        throw new RuntimeException("");
    }
}
