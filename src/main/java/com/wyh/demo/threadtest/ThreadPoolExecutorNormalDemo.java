package com.wyh.demo.threadtest;

import java.util.concurrent.*;

/**
 * @author imai
 * @since 2021/1/9 5:16 下午
 */
public class ThreadPoolExecutorNormalDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,3,60L, TimeUnit.SECONDS,
                queue,new ThreadPoolExecutor.DiscardOldestPolicy());
        for(int i = 1;i<=9;i++){
            pool.submit(new PrintTask(i));
        }
        pool.shutdown();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService scheduledThreadPool  = Executors.newScheduledThreadPool(10);
        ExecutorService singleThreadScheduledExecutor= Executors.newSingleThreadScheduledExecutor();
    }
    static class PrintTask implements Runnable{
        private final int t;

        public PrintTask(int t) {
            this.t = t;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t);
        }
    }

    static class CallableTask implements Callable<String>{
        private final int n;

        public CallableTask(int n) {
            this.n = n;
        }

        @Override
        public String call() throws Exception {
            return "";
        }
    }
}
