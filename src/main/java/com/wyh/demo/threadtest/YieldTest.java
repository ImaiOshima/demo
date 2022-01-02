package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2020/12/29 上午12:14
 */
public class YieldTest implements Runnable{
    YieldTest(){
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }

    @Override
    public void run() {
        for (int i = 0;i<5;i++){
            if(i%5==0){
                System.out.println(Thread.currentThread() + "yield cpu");
                //Thread.yield();
            }
        }
        System.out.println(Thread.currentThread()+"is over");
    }
}
