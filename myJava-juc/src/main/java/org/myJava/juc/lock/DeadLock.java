package org.myJava.juc.lock;

/**
 * 死锁
 * jps -l 列出当前进程
 * jstack pid 查看堆栈内容(最后会有死锁提示)
 */
public class DeadLock {

    public static void main(String[] args) {
        Thread t9 = new Thread(new InnerDeadLock(true));
        Thread t10 = new Thread(new InnerDeadLock(false));
        t9.start();
        t10.start();
    }
}



class InnerDeadLock implements Runnable{

    boolean lockFormer;
    static Object o1 = new Object();
    static Object o2 = new Object();

    InnerDeadLock(boolean lockFormer){
        this.lockFormer = lockFormer;
    }

    @Override
    public void run() {
        if(this.lockFormer){
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1ok");
                }
            }
        }else{
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("1ok");
                }
            }
        }
    }
}
