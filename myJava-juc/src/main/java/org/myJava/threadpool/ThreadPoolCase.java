package org.myJava.threadpool;

import java.util.concurrent.Executors;

public class ThreadPoolCase {

    public static void main(String[] args) {
        // 线程池基本参数

        // 线程池执行流程

        // 线程池工作队列选择

        // 自定义线程池

        Executors.newCachedThreadPool(); // SynchronousQueue
        Executors.newCachedThreadPool(); // SynchronousQueue
        Executors.newFixedThreadPool(1); // LinkedBlockingQueue
        Executors.newSingleThreadExecutor(); // LinkedBlockingQueue
        Executors.newScheduledThreadPool(1); // DelayedWorkQueue

    }
}
