package com.wyh.demo.threadtest;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Classname CompletableFuture
 * @Description TODO
 * @Date 2022/7/12 20:45
 * @Created by 61635
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            return "hello world";
        });
        System.out.println(future.get());
    }
}
