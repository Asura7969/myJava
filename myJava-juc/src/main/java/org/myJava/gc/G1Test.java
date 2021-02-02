package org.myJava.gc;

/**
 * https://zhuanlan.zhihu.com/p/131643439
 *
 * -verbose:gc -Xms10m -Xmx10m -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:MaxGCPauseMillis=200m
 */
public class G1Test {

    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;
        byte[] arr1 = new byte[size];
        createOneM();
        System.out.println("createOneM ---------------");
        byte[] arr2 = new byte[size];
        System.out.println("222222222 ----------------");
        byte[] arr3 = new byte[size];
        System.out.println("333333333 ----------------");
        createOneM();
        System.out.println("createOneM2 ---------------");
        Thread.sleep(2000);
        byte[] arr5 = new byte[size];
        System.out.println("555555 ---------------");

    }

    public static void createOneM() {
        byte[] bytes = new byte[1024 * 1024];
    }
}
