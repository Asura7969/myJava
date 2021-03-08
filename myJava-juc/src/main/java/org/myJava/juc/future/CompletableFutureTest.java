package org.myJava.juc.future;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * 参考： https://chinalhr.github.io/post/java-asyncprogram/
 */
public class CompletableFutureTest {

    private final static Logger log = LoggerFactory.getLogger(CompletableFutureTest.class);

    private final static int AVALIABLE_PROCESSORS = 2;

    private final static ThreadPoolExecutor POOL_EXECUTOR =
            new ThreadPoolExecutor(AVALIABLE_PROCESSORS, AVALIABLE_PROCESSORS * 2,
                    1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws Exception {
        supplyAsync();
//        thenRunAsync();
//        thenAcceptAsync();
//        whenCompleteAsync();
//        thenCompose();




    }

    /**
     * todo:
     *      allOf：等待多个并发运行的CompletableFuture任务执行完毕
     *      anyOf：等多个并发运行的CompletableFuture任务任意一个执行完毕
     */

    // thenCompose : 当一个CompletableFuture执行完毕后，执行另外一个CompletableFuture
    public static void thenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "task from supplyAsync", POOL_EXECUTOR);
        CompletableFuture<String> sf = future.thenCompose(new Function<String, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(String s) {
                return CompletableFuture.supplyAsync(() -> "任务2 : " + s);
            }
        });
        String s = sf.get();
        System.out.println(s);
    }

    // 设置回调函数，通过回调函数不会阻塞线程
    public static void whenCompleteAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "task from supplyAsync", POOL_EXECUTOR);
        future.whenCompleteAsync((s, throwable) -> {
            if (Objects.nonNull(s)) {
                System.out.println("result: " + s);
            }
        }, POOL_EXECUTOR);
        System.out.println(Thread.currentThread().getName());
    }

    // thenAcceptAsync : 异步任务执行完激活其他任务，其他任务会获取之前任务的返回值
    public static void thenAcceptAsync() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "执行异步任务-1-结果";
        }).thenAcceptAsync((result) -> System.out.println("执行异步任务-2 获取之前任务的结果 " + result))
                .join();
    }

    // thenRunAsync : 异步任务执行完激活其他任务，其他任务不会获取之前任务的返回值
    public static void thenRunAsync() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "执行异步任务-1";
        }).thenRunAsync(() -> System.out.println("执行异步任务-2"))
                .join();
    }

    // runAsync : 异步无返回值
    public static void runAsync() {
        CompletableFuture.runAsync(() -> System.out.println("异步无返回值"), POOL_EXECUTOR).join();
    }

    // supplyAsync : 异步有返回值
    public static void supplyAsync() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(CompletableFutureTest::syncIo, POOL_EXECUTOR);
        cf.thenAccept((result) -> {
            System.out.println("返回结果是: " + result);
        });

        // 异常处理
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        System.out.println("main 线程等待返回结果！");

        cf.join();
        System.out.println("join 阻塞");

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
