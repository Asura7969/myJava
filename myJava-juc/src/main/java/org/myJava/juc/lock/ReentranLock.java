package org.myJava.juc.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport 实现可重入锁
 */
public class ReentranLock {
    private volatile int state = 0;
    private final BlockingQueue<Thread> queue = new ArrayBlockingQueue<>(10);

    public void lock() {
        Thread currentThread = Thread.currentThread();
        Thread peek = queue.peek();
        if(null != peek) {
            if(peek.equals(currentThread)){
                state += 1;
            } else {
                LockSupport.park(currentThread);
                System.out.println("阻塞当前线程 " + currentThread.getName() + " ,有线程正在执行");
                queue.add(currentThread);
            }
        } else {
            state += 1;
            queue.add(currentThread);
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        Thread t = queue.peek();
        if(null != t) {
            if(t.equals(currentThread)){
                if(state > 1){
                    state -= 1;
                } else if(state == 1){
                    queue.poll();
                    Thread next = queue.peek();
                    if(null != next){
                        LockSupport.unpark(next);
                    } else {
                        state -= 1;
                    }
                }
            } else {
                throw new RuntimeException("执行异常");
            }
        } else {
            throw new RuntimeException("当前没有线程执行！");
        }
    }


    static class ValueNum{
        private final ReentranLock lock = new ReentranLock();
        public int i;
        public void plus(){
            lock.lock();
            i ++;
            get();
            lock.unlock();
        }

        public void get(){
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 打印 i 的值:" + i);
            lock.unlock();
        }
    }


    public static void main(String[] args) throws Exception {
        ValueNum num = new ValueNum();
        new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    num.plus();
                    System.out.println("t1 执行完毕");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"thread-1").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    num.plus();
                    System.out.println("t2 执行完毕");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("t2 执行完毕");
        },"thread-2").start();

        Thread.sleep(1000000L);


    }






}
