package org.myJava.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] testArr = new int[]{1,3,7,9,2,5,8,10};
        int[] result = sort(testArr);
        System.out.println(Arrays.asList(result));
    }

    public static int[] sort(int[] arr){
        if(arr.length < 2){
            return arr;
        }

        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0){
            if(left[0] < right[0]){
                result[i] = left[0];
                i ++;
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i] = right[0];
                i ++;
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0){
            result[i] = left[0];
            i ++;
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0){
            result[i] = right[0];
            i ++;
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
