package com.wyh.demo.threadtest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author imai
 * @since 2021/2/18 11:57 下午 ReentrantReadWriteLock
 * readLock demo 读读不互斥
 */
public class ReentrantReadWriteLockTest {
    // 读写锁
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void get(Thread thread) {
        lock.readLock().lock();
        System.out.println("start time:" + System.currentTimeMillis());
        for (int i = 0; i < 5; ++i) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ":正在读取中");
        }
        System.out.println(thread.getName() + ":读取完毕");
        System.out.println("end time:" + System.currentTimeMillis());
        lock.readLock().unlock();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            get(Thread.currentThread());
        }).start();

        new Thread(() -> {
            get(Thread.currentThread());
        }).start();
    }
}
