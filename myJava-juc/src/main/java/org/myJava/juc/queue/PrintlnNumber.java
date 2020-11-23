package org.myJava.juc.queue;

import java.util.concurrent.TimeUnit;

/**
 * 多线程交替打印自然数
 */
public class PrintlnNumber {

    public static void main(String[] args) {
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
