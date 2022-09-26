package com.wyh.demo.test;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.concurrent.TimeUnit;

/**
 * @Classname EscapeTest
 * @Description TODO
 * @Date 2022/9/20 0:33
 * @Created by 61635
 */
public class EscapeTest {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i<=1000;i++){
            getAge();
        }
        TimeUnit.HOURS.sleep(1);
    }

    public static int getAge(){
        Studetn studetn = new Studetn("小明",18);
        return studetn.getAge();
    }

    static class Studetn{
        private String name;
        private int age;

        public Studetn(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
