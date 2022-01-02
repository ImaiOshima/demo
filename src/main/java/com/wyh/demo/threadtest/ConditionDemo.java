package com.wyh.demo.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author imai
 * @since 2021/1/7 下午10:27
 */
public class ConditionDemo {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition CONDITION = lock.newCondition();

    public static void main(String[] args) {
        lock.lock();
        try {
            System.out.println("begin wait");
            CONDITION.await();
            System.out.println("end wait");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        lock.lock();
        try {
            System.out.println("begin wait");
            CONDITION.signal();
            System.out.println("end wait");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
