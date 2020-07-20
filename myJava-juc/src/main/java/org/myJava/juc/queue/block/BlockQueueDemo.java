package org.myJava.juc.queue.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println("queue size : " + queue.size());
        Integer item = queue.poll();
        System.out.println(item);
        queue.add(11);


    }
}
