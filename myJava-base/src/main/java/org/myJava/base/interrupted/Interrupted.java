package org.myJava.base.interrupted;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author gongwenzhou@hellobike.com
 * @Date 2021/8/30 10:16 上午
 * @Describe TODO
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        MyTh t2 = new MyTh(t);
        t2.start();

        Thread.sleep(5000L);
        t.interrupt();

        if (t.interrupted()) {
            System.out.println("恢复线程");
        }


        Thread.sleep(10000L);
        System.out.println("main线程结束");

    }

    static class MyThread extends Thread {
        static LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<>();

        public void add(Integer i) {
            q.add(i);
        }

        @Override
        public void run() {
            for (;;) {
                Integer j = null;
                try {
                    j = q.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("线程 take 中断");
                    continue;
                }
                System.out.println(j);
            }
        }
    }

    static class MyTh extends Thread {
        private MyThread t;

        public MyTh(MyThread t) {
            this.t = t;
        }

        @Override
        public void run() {

            for (int i = 0; i < 100000; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.add(i);
            }
        }
    }
}
