package com.wyh.demo.test;

import java.util.concurrent.*;

public class TestUnsafe {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,7,0L,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        Future<Integer> task = threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
    }
}
