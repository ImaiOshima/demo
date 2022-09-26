package com.wyh.demo.test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2022/9/20 9:25 上午
 */
public class EscapeTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for(int i = 0;i<1000000;i++){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.printf("时间消耗"+ (end - start));
        TimeUnit.HOURS.sleep(1);
    }

    public static void alloc(){
        User user = new User();
    }
}

class User{

}
