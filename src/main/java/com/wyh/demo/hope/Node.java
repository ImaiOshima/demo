package com.wyh.demo.hope;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Node
 * @Description TODO
 * @Date 2022/9/6 0:20
 * @Created by 61635
 */
public class Node{
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
