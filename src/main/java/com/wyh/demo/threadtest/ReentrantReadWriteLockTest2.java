package com.wyh.demo.threadtest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author imai
 * @since 2021/2/19 12:18 上午
 * writeLock demo 读写互斥 写写互斥
 */
public class ReentrantReadWriteLockTest2 {
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.submit(()->{
            readFile(Thread.currentThread());
        });

        threadPoolExecutor.submit(()->{
            writeFile(Thread.currentThread());
        });
        threadPoolExecutor.shutdown();
    }

    public static void readFile(Thread thread){
        lock.readLock().lock();
        boolean readLock = lock.isWriteLocked();
        if(!readLock){
            System.out.println("当前为读锁");
        }
        try{
            for(int i = 0;i<5;++i){
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() +":正在读");
            }
            System.out.println(thread.getName() + ":操作完毕");
        }finally {
            System.out.println("释放读锁");
            lock.readLock().unlock();
        }
    }

    // 写操作
    public static void writeFile(Thread thread) {
        lock.writeLock().lock();
        boolean writeLock = lock.isWriteLocked();
        if (writeLock) {
            System.out.println("当前为写锁！");
        }
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + ":正在进行写操作……");
            }
            System.out.println(thread.getName() + ":写操作完毕！");
        } finally {
            System.out.println("释放写锁！");
            lock.writeLock().unlock();
        }
    }

}
