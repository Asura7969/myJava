package org.myJava.algorithm;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] testArr = new int[]{1,3,7,9,2,5,8,10};
        int[] sorted = sort(testArr);
        System.out.println(sorted);
    }

    public static int[] sort(int[] arr){
        if(arr.length < 2){
            return arr;
        }
        int currIndex = 0;
        while (currIndex < arr.length - 1){
            for (int i = currIndex; i < arr.length; i++) {
                if(arr[i] < arr[currIndex]){
                    swap(arr, i, currIndex);
                }
            }
            currIndex ++;
        }
        return arr;
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
