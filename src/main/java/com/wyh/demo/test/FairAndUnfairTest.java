package com.wyh.demo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author imai
 * @since 2021/2/1 10:10 下午
 */
public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    private void testLock(Lock lock){
        for(int i = 0;i<5;i++){
            Job job = new Job(lock);
            job.setName("线程"+(i+1));
            job.start();
        }
    }

    public static void main(String[] args) {
        FairAndUnfairTest test = new FairAndUnfairTest();
//        test.testLock(fairLock);
         test.testLock(unfairLock);
    }

    public static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            for(int i =0;i<2;i++){
                lock.lock();
                try{
                    Collection<Thread> threads = ((ReentrantLock2)lock).getQueuedThreads();
                    Thread.sleep(1000);
                    System.out.println("获取锁的当前线程["+Thread.currentThread().getName()+"],同步队列中的线程"+
                        getThreadName(threads));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    private static String getThreadName(Collection<Thread> threads){
        StringBuilder sb = new StringBuilder();
        if(threads != null){
            for(Thread thread:threads){
                sb.append(thread.getName()).append(",");
            }
        }
        String waitingThreads = null;
        if(sb.length()>0){
            waitingThreads = sb.substring(0,sb.length() -1);
        }
        return waitingThreads;
    }

    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair){
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
