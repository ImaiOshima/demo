package com.wyh.demo.threadtest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {

    public static volatile int race = 0;
    public static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            long startTime = System.currentTimeMillis();
//            System.out.println("start_time:"+startTime);
//            synchronized (CountDownLatchDemo2.class) {
//                for (int i = 0; i < 100000; i++) {
//                    race++;
//                }
//            }
            for (int i = 0; i < 100000; i++) {
                synchronized (CountDownLatchDemo2.class) {
                    race++;
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("end-start:" + (endTime-startTime));
            countDownLatch.countDown();
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        countDownLatch.await();
        System.out.println("end: "+ race);
    }
}
