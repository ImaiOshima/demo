package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2020/12/29 上午1:35
 */
public class InterruptTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(Thread.interrupted()){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        thread.interrupt();
        thread.join();
        System.out.println("mian thread is over");
    }
}
