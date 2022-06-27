package com.wyh.demo.threadtest;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname MyBlockingQueueForCondition
 * @Description TODO
 * @Date 2022/6/19 22:25
 * @Created by 61635
 */
public class MyBlockingQueueForCondition {
    private Queue<Object> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public MyBlockingQueueForCondition(int size){
        this.max = size;
        this.queue = new LinkedList<Object>();
    }

    public void put(Object o){
        //lock.lock();
        
    }
}
