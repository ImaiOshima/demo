package com.wyh.demo.threadtest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author imai
 * @since 2020/11/15 下午9:30
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i = 0;i<10;++i){
            exec.submit(demo);
        }
        end.await();
        System.out.println("Fire");
        exec.shutdown();
    }

    @Override
    public void run() {
        try{
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("the factory: " + Thread.currentThread().getName());
            System.out.println("check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
