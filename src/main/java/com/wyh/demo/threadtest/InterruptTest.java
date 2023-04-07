package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2020/12/29 上午12:56
 */
public class InterruptTest {
    // 停止线程的最佳方法
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //实力方法 判断当前线程是否已经被打断
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "hello");
                }
                System.out.println("run over");
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread interrupt thread");
        // 实例方法 被打断的方法
        thread.interrupt();
        //
        //thread.join();
        System.out.println("main over");
    }

}
