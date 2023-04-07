package com.wyh.demo.threadtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author imai
 * @since 2021/2/1 11:34 下午
 */
public class SynchronizedTest {
    private static int i = 0;


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                sout();
            }
        });

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                sout();
            }
        });

        threadPoolExecutor.shutdown();
    }

    public static synchronized void sout(){
        System.out.println(++i);
    }
}
