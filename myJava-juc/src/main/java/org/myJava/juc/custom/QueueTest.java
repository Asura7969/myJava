package org.myJava.juc.custom;

public class QueueTest {
    public static void main(String[] args) {
        SampleBlockQueue<String> q = new SampleBlockQueue<>(10);
        try {
            new Thread(() ->{
                try {
                    String takeE = q.take();
                    System.out.println(Thread.currentThread().getName() + "  " + takeE + " ------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"take1").start();

            new Thread(() ->{
                try {
                    String takeE = q.take();
                    System.out.println(Thread.currentThread().getName() + "  " + takeE + " ------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"take2").start();

            Thread.sleep(5000L);
            new Thread(() ->{
                try {
                    q.put("2000");
                    System.out.println(Thread.currentThread().getName() + "  " + "put 完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"put1").start();

            Thread.sleep(5000L);
            new Thread(() ->{
                try {
                    q.put("5000");
                    System.out.println(Thread.currentThread().getName() + "  " + "put 完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"put2").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
