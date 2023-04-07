package com.wyh.demo.threadtest;

import java.util.concurrent.*;

/**
 * @author imai
 * @since 2021/1/6 下午9:41
 */
public class CycleBarrierTest {
    private final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(3, () -> {
        System.out.println(Thread.currentThread());
    });

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,0L,
                TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.submit(()->{
            System.out.println("task1 start");
            try {
                CYCLIC_BARRIER.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("task1 end");
        });
        
        threadPoolExecutor.submit(()->{
            System.out.println("task2 start");
            try{
                CYCLIC_BARRIER.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("task2 end");
        });

        threadPoolExecutor.submit(()->{
            System.out.println("task3 start");
            try{
                CYCLIC_BARRIER.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("task3 end");
        });

        threadPoolExecutor.shutdown();
    }
}
