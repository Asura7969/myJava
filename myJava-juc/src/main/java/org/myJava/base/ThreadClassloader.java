package org.myJava.base;

public class ThreadClassloader {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
