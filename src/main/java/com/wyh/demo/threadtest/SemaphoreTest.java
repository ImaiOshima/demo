package com.wyh.demo.threadtest;

import java.util.concurrent.Semaphore;

/**
 * @author imai
 * @since 2021/2/6 12:24 下午
 */
public class SemaphoreTest {
    private final static Semaphore SEMAPHORE = new Semaphore(5);
    public static void main(String[] args) {
        for(int i = 0;i<8;++i){
            final String name = "工人" + i;
            new Thread(()->{
                try{
                    SEMAPHORE.acquire();
                    System.out.println(name + "占用一个机器生产...");
                    Thread.sleep(2000);
                    System.out.println(name + "释放出机器");
                    SEMAPHORE.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
