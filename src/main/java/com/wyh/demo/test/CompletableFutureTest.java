package com.wyh.demo.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author imai
 * @since 2023/5/2 00:46
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future =
            CompletableFuture.supplyAsync(()->"resultA").thenApply(resultA-> resultA + " resultB")
                .thenApply(resultB -> resultB + " resultC");
        String value = future.join();
        System.out.println(value);
    }
}
