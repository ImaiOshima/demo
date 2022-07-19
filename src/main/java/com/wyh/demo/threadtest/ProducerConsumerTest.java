package com.wyh.demo.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author imai
 * @since 2021/2/1 11:15 下午
 */
public class ProducerConsumerTest {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile boolean hasValue = false;

    public void producer(){
        lock.lock();
        try{
            while(hasValue){
                condition.await();
            }
            System.out.println("生产");
            hasValue = true;
            condition.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try{
            while(!hasValue){
                condition.await();
            }
            System.out.println("消费");
            hasValue = false;
            condition.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ProducerConsumerTest producerConsumerTest = new ProducerConsumerTest();

        new Thread(()->{
            for(int i = 0;i<100;i++){
                producerConsumerTest.producer();
            }
        }).start();

        new Thread(()->{
            for(int i = 0;i<100;i++){
                producerConsumerTest.consume();
            }
        }).start();
    }
}
