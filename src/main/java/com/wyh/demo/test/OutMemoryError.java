package com.wyh.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname OutMemoryError
 * @Description TODO
 * @Date 2022/2/23 23:11
 * @Created by 61635
 */
public class OutMemoryError {
    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
