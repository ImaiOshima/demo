package com.wyh.demo.test;

import java.util.UUID;

/**
 * @author imai
 * @since 2020/12/24 上午12:12
 */
public class Sort {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        System.out.println(uuid);
    }
}
