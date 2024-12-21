package com.wyh.demo.design.proxy.jdkproxy;

import com.wyh.demo.test.A;

import java.util.ArrayList;

/**
 * Project Name: demo
 * File Name: null.java
 * Author: 61635
 * Date: 2024/11/17
 * Description: [这里写该文件的简要描述]
 */
public class MetricsCollector {

    public void recordRequest(RequestInfo info){
        System.out.println("bbb");
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        MetricsCollector ac = new MetricsCollector();
        ac.recordRequest(new RequestInfo());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
    }
}
