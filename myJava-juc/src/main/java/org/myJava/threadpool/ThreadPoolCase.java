package org.myJava.threadpool;

import java.util.concurrent.Executors;

public class ThreadPoolCase {

    public static void main(String[] args) {
        /**
         * 线程池基本参数
         *      1、最大线程数 maximumPoolSize
         *      2、空闲线程过多久被回收的时间限制 keepAliveTime
         *      3、时间单位
         *      4、核心线程数 corePoolSize
         *      5、线程工厂类
         *      6、工作队列
         *      7、拒绝策略
         *  当线程池满了会有哪些操作?
         *      如果当线程池中线程数小于 corePoolSize ,则会创建线程；
         *      若达到 corePoolSize,则会放入 workQueue 中等待调度
         *      当 workQueue 已满，且 maximumPoolSize > corePoolSize时, 新建的任务会执行拒绝策略
         *      当 workQueue 已满，且提交任务数超过 maximumPoolSize, 任务由 RejectedExecutionHandler 处理
         *      当线程池中线程数超过 corePoolSize, 且超过这部分的空闲时间达到 keepAliveTime 时，回收这些线程
         *      当设置 allowCoreThreadTimeOut(true) 时, 线程池中 corePoolSize 范围内的线程空闲时间达到 keepAliveTime 也将回收。
         */

        /**
         * 线程池工作队列选择
         * SynchronousQueue: 有公平（FIFO）和非公平两种策略，内部没有数据缓存空间，不能像其他Queue 可以 “偷窥” 一下队列中是否有元素
         * LinkedBlockingQueue: 单向链表实现的阻塞队列(FIFO)
         * DelayedWorkQueue: 优先级队列
         */


        /* 使用场景 */

        // 用于执行并发大量小任务，或是负载较轻的服务器
        Executors.newCachedThreadPool(); // SynchronousQueue

        // 用于负载比较重的服务器，为了资源的合理利用，需要限制当前线程数量
        Executors.newFixedThreadPool(1); // LinkedBlockingQueue

        // 用于串行执行任务的场景，每个任务必须按顺序执行，不需要并发执行
        Executors.newSingleThreadExecutor(); // LinkedBlockingQueue

        // 延迟或周期执行任务
        Executors.newScheduledThreadPool(1); // DelayedWorkQueue


    }
}
