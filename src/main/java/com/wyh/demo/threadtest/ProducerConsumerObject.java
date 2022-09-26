package com.wyh.demo.threadtest;

import com.wyh.demo.threadtest.ReentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname ProducerConsumerObject
 * @Description TODO
 * @Date 2022/9/25 17:02
 * @Created by 61635
 */
public class ProducerConsumerObject {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] item = new Object[100];
    int count,putIndex,takeIndex;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try{
            while(count == item.length){
                notFull.wait();
            }
            item[putIndex] = x;
            count++;
            if(++putIndex == item.length) putIndex = 0;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try{
            while(count == 0){
                notEmpty.wait();
            }
            Object x = item[takeIndex];
            count--;
            if(++takeIndex == item.length) takeIndex = 0;
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }
}
