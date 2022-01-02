package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2021/6/16 9:11 下午
 */
public class VolatileTest {
    static class Work{
        boolean isShotDown = false;

        void shutdown(){
            this.isShotDown = true;
            System.out.println("shutDown");
        }

        void doWork(){
            while(!isShotDown) {
                System.out.println("doWork");
            }
        }
    }

    public static void main(String[] args) {
        Work work = new Work();
        new Thread(work::doWork).start();
        new Thread(work::doWork).start();
        new Thread(work::doWork).start();
        new Thread(work::doWork).start();
        new Thread(work::doWork).start();
        new Thread(work::doWork).start();
        new Thread(work::doWork).start();
        new Thread(work::shutdown).start();
    }
}
