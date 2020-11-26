package org.myJava.algorithm;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] testArr = new int[]{1,3,7,9,2,5,8,10};
        int[] sorted = sort(testArr);
        System.out.println(sorted);
    }

    public static int[] sort(int[] arr){
        if(arr.length < 2){
            return arr;
        }

        int le = arr.length;
        while (le != 0){
            for (int i = 0; i < le - 1; i++) {
                int i1 = i+1;
                if(arr[i] < arr[i1]){
                    swap(arr, i, i1);
                }
            }
            le --;
        }
        return arr;
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
