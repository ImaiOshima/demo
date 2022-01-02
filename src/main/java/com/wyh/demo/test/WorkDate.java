package com.wyh.demo.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author imai
 * @since 2020/12/17 上午12:40
 */
public class WorkDate {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.parse("2020-01-01T11:22:33");
        System.out.println(Timestamp.valueOf(time));
    }
}
