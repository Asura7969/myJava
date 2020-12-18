package org.myJava.algorithm;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] sortArray = new int[]{1,3,5,7,9,10,55,100};
        int index = binarySearch(sortArray, 3);
        System.out.println(index == 1);
    }

    private static int binarySearch(int[] sortArray, int value) {
        int left = 0;
        int right = sortArray.length - 1;
        int mid = (right - left) / 2;
        while (left <= right){
            if(sortArray[mid] == value){
                return mid;
            } else if(sortArray[mid] > value){
                right = mid;
                mid = (right - left) / 2;
            } else {
                left = mid;
                mid = left + (right - left) / 2;
            }
        }
        return mid;
    }
}
