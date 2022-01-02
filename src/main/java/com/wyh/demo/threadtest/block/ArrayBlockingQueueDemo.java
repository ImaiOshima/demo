package com.wyh.demo.threadtest.block;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author imai
 * @since 2021/4/4 4:13 下午
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
    }
}
