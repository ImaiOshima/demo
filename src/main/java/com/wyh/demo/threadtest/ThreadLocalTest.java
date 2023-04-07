package com.wyh.demo.threadtest;

/**
 * @author imai
 * @since 2020/12/30 上午2:43
 */
public class ThreadLocalTest {
    static ThreadLocal<String> localVarible = new ThreadLocal<>();
    static ThreadLocal<Integer> localInteger = new ThreadLocal<>();
    static ThreadLocal<Integer> localInteger2 = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVarible.set("thread One");
                localInteger.set(1);
                localInteger2.set(8);
                //print("threadOne");
                System.out.println("threadOne remove after " + localVarible.get());
                System.out.println("threadOne remove after " + localInteger.get());
                System.out.println("threadOne remove after " + localInteger2.get());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVarible.set("thread Two");
                localInteger.set(2);
                localInteger2.set(9);
                //print("threadTwo");
                System.out.println("threadTwo remove after " + localVarible.get());
                System.out.println("threadTwo remove after " + localInteger.get());
                System.out.println("threadTwo remove after " + localInteger2.get());
            }
        });
        threadOne.start();
        threadTwo.start();
    }

    public static void print(String v) {
        System.out.println(v + "--" + localVarible.get());
        System.out.println(v + "--" + localInteger.get());
        System.out.println(v + "--" + localInteger2.get());
    }
}
