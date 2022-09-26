package com.wyh.demo.threadtest;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Classname InterruptTest2
 * @Description TODO
 * @Date 2022/9/26 11:38
 * @Created by 61635
 */
public class InterruptTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("-----" + Thread.currentThread().isInterrupted());
                    Thread.interrupted();
                    System.out.println("-----"+ Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
