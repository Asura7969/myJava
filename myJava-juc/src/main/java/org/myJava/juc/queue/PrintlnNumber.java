package org.myJava.juc.queue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程交替打印自然数
 */
public class PrintlnNumber {

    public static void main(String[] args) {

//        synchronizedPrintNum();
        lockPrintNum();



    }

    static void lockPrintNum(){
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        CountDownLatch c = new CountDownLatch(1);

        double[] data1 = new double[]{1,2.5,4,5.5,7,8.5,10};
        double[] data2 = new double[]{1.5,3,4.5,6,7.5,9,10.5};
        double[] data3 = new double[]{2,3.5,5,6.5,8,9.5,11};

        new Thread(() -> {
            lock.lock();
            try{
                for (int i = 0; i < data1.length; i++) {
                    System.out.println(data1[i]);
                    condition2.signal();
                    c.countDown();
                    condition1.await();
                }
                condition1.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"work1").start();

        new Thread(() -> {

            lock.lock();
            try{
                c.await();
                for (int i = 0; i < data2.length; i++) {
                    System.out.println(data2[i]);
                    condition3.signal();
                    condition2.await();
                }
                condition2.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"work2").start();

        new Thread(() -> {

            lock.lock();
            try{
                c.await();
                for (int i = 0; i < data3.length; i++) {
                    System.out.println(data3[i]);
                    condition1.signal();
                    condition3.await();
                }
                condition3.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"work3").start();
    }

    static void synchronizedPrintNum(){
        Object obj = new Object();
        Thread a = new Thread(new PrintNum(obj, true), "thread-1");
        Thread b = new Thread(new PrintNum(obj, false), "thread-2");
        Thread c = new Thread(new PrintNum(obj, false), "thread-3");
        Thread d = new Thread(new PrintNum(obj, false), "thread-4");

        b.start();
        c.start();
        d.start();
        a.start();
    }


    static class PrintNum implements Runnable{
        private Object obj;
        private static int num;
        private Boolean isFirst;

        public PrintNum(Object obj, Boolean isFirst){
            num = 0;
            this.obj = obj;
            this.isFirst = isFirst;
        }

        @Override
        public void run() {
            synchronized (obj){
                while (true){
                    if(isFirst){
                        this.isFirst = false;
                    } else {
                        try {
                            obj.wait();
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + num++);
                    obj.notify();
                }
            }

        }
    }
}
