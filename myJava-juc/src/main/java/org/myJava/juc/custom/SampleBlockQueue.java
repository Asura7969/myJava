package org.myJava.juc.custom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SampleBlockQueue<T> {

    private Object[] data;
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;
    private int total = 0;

    public <T> SampleBlockQueue(int capacity){
        this.data = new Object[capacity];
        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    public T take() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try{
            System.out.println(Thread.currentThread().getName());
            while (total == 0L){
                notEmpty.await();
            }
            Object[] objects = this.data;
            total--;
            return (T)objects[0];
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void put(T elem) throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try{
            Object[] objects = this.data;
            if(total == 0){
                objects[0] = elem;
            } else {
                objects[total + 1] = elem;
            }

            total++;
//            notFull.signal();
            notEmpty.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
