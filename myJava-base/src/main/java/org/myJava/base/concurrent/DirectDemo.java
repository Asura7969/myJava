package org.myJava.base.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author asura7969
 * @create 2021-08-21-13:13
 */
public class DirectDemo {

    public static void main(String[] args) throws Exception {


        final DirectExecutorService directExecutor = new DirectExecutorService();

        directExecutor.execute(() -> {
            final String name = Thread.currentThread().getName();
            System.out.println("execute - 当前线程:" + name);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Future<?> submit = directExecutor.submit(() -> {
            final String name = Thread.currentThread().getName();
            System.out.println("submit - 当前线程:" + name);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("main 线程执行结束");

        System.out.println("等待 future 结果");
        submit.get();
    }
}
