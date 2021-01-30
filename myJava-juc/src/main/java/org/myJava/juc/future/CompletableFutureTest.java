package org.myJava.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(CompletableFutureTest::syncIo);
        System.out.println("main 线程等待返回结果！");
        cf.thenAccept((result) -> {
            System.out.println("返回结果是: " + result);
        });
        // 异常处理
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        Thread.sleep(10000L);
    }

    public static String syncIo() {
        try {
            System.out.println(Thread.currentThread().getName() + " 执行调用！");
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result";
    }
}
