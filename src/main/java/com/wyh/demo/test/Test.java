package com.wyh.demo.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    private final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,0L,
                TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.submit(()->{
           try{
               System.out.println("threadOne");
               Thread.sleep(1000);
           }catch(Exception e){
               e.printStackTrace();
           }finally {
               COUNT_DOWN_LATCH.countDown();
           }
        });
        threadPoolExecutor.submit(()->{
            try{
                System.out.println("threadTwo");
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                COUNT_DOWN_LATCH.countDown();
            }
        });
        COUNT_DOWN_LATCH.await();
        System.out.println("end");
        threadPoolExecutor.shutdown();
    }
}
