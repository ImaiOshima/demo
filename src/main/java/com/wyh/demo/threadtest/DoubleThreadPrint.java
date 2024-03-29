package com.wyh.demo.threadtest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author imai
 * @since 2021/1/22 8:52 下午
 */
public class DoubleThreadPrint {
    static volatile int i =1;
    static final ReentrantLock lock = new ReentrantLock();
    static final Condition condition = lock.newCondition();
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,0L, TimeUnit.SECONDS
        ,new ArrayBlockingQueue<>(10));
        threadPoolExecutor.submit(()->{
            print();
        });
        threadPoolExecutor.submit(()->{
            print();
        });
    }

    public static void print(){
        while(i<=100){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() +"--"+i );
                i++;
                condition.signal();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
