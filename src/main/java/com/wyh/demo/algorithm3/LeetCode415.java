package com.wyh.demo.algorithm3;

/**
 * @Classname LeetCode415
 * @Description TODO
 * @Date 2022/7/5 18:02
 * @Created by 61635
 */
public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length() -1;
        int n2 = num2.length() -1;
        int carry = 0;
        int v1,v2,v,tmp;
        while(n1 >= 0 || n2 >=0){
            v1 = n1 < 0? 0:num1.charAt(n1) - '0';
            v2 = n2 < 0 ?0:num2.charAt(n2) - '0';
            v = v1 + v2 + carry;
            carry = v/10;
            tmp = v%10;
            sb.append(tmp);
            n1--;n2--;
        }
        if(carry>0){sb.append(carry);}
        return sb.reverse().toString();
    }
}
