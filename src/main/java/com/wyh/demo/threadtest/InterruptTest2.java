package com.wyh.demo.threadtest;

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
                    //充值 线程的被打断状态 静态方法
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
