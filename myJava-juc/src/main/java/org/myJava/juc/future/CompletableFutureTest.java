package org.myJava.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete(syncIo());

        String s = future.get(1000L, TimeUnit.MILLISECONDS);
        System.out.println(s);
    }

    public static String syncIo() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result";
    }
}
