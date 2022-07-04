package com.wyh.demo.algorithm3;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Classname LeetCode20
 * @Description TODO
 * @Date 2022/7/4 16:04
 * @Created by 61635
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if(len%2==1){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i = 0;i<len;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.add(c);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
