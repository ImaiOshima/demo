package com.wyh.demo.threadtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author imai
 * @since 2021/2/19 12:10 上午
 */
public class ReentrantLockTest {
    static ReentrantLock lock = new ReentrantLock();

    public static void get(Thread thread) {
        lock.lock();
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
        lock.unlock();
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
