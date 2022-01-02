package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2020/12/29 上午12:56
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "hello");
                }
                System.out.println("run over");
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread interrupt thread");
        thread.interrupt();
        //
        //thread.join();
        System.out.println("main over");
    }

}
