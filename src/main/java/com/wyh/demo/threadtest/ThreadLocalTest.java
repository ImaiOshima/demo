package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2020/12/30 上午2:43
 */
public class ThreadLocalTest {
    static ThreadLocal<String> localVarible = new ThreadLocal<>();
    static ThreadLocal<Integer> localIntger = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVarible.set("thread One");
                localIntger.set(1);
                print("threadOne");
                System.out.println("threadOne remove after " + localVarible.get());
                System.out.println("threadOne remove after " + localIntger.get());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVarible.set("thread Two");
                localIntger.set(2);
                print("threadTwo");
                System.out.println("threadTwo remove after " + localVarible.get());
                System.out.println("threadTwo remove after " + localIntger.get());
            }
        });
        threadOne.start();
        threadTwo.start();
    }

    public static void print(String v){
        System.out.println(v+"--"+localVarible.get());
    }
}
