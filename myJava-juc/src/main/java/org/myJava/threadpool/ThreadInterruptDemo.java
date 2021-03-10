package org.myJava.threadpool;


import java.util.ArrayList;
import java.util.List;

public class ThreadInterruptDemo {
    private static List<String> list = new ArrayList<>();
    private static int i = 0;
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000L);
                    list.add("" + i);
                    i += 1;
                }
                System.out.println("线程中断后还会继续执行循环外的数据");
            } catch (InterruptedException e) {
                /**
                 * 注：线程抛出异常（InterruptedException）后会 清除中断标记
                 *
                 * interrupt(): 给线程发出中断信号
                 *
                 * isInterrupted(): 判断线程是否中断，不会清楚中断标记
                 *
                 * interrupted(): 判断线程是否中断，清除中断标记
                 */
//                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }, "thread1");
        thread1.start();
        Thread.sleep(5000);
        thread1.interrupt();
        System.out.println("thread1 是否存活: " + thread1.isAlive());
        System.out.println(list);
        System.out.println("thread1 是否中断: " + thread1.isInterrupted());

//        thread1.stop();
//        System.out.println("thread1 stop 后 是否存活: " + thread1.isAlive());

        Thread.sleep(20000);
        System.out.println(list);
        thread1.start();

        Thread.sleep(5000);
        System.out.println(list);
    }
}
