package org.myJava.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] testArr = new int[]{1,3,7,9,2,5,8,10};
        int[] result = quickSort(testArr, 0, testArr.length - 1);
        System.out.println(Arrays.asList(result));
    }

    public static int[] quickSort(int[] arr, int left, int right){
        if(left < right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i < arr.length; i++) {
            if(arr[i] < arr[pivot]){
                swap(arr, i, index);
                index ++;
            }
        }
        swap(arr, index - 1, pivot);
        return index - 1;
    }

    public static void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
