package com.wyh.demo.threadtest;

import java.util.concurrent.locks.LockSupport;

/**
 * @author imai
 * @since 2021/2/1 9:34 下午
 */
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        String a = new String("A");
        Thread t = new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("睡觉");
            LockSupport.park(a);
            System.out.println("起床");
            System.out.println(Thread.currentThread().isInterrupted());
        });
        t.setName("A-name");
        t.start();
        LockSupport.unpark(t);
        System.out.println("突然肚子痛");
        LockSupport.unpark(t);
    }
}
