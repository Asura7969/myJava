package org.myJava;

import java.util.Arrays;

public class AlgorithmTest {

    public static void main(String[] args) {
        int[] testArr = new int[]{1,3,7,9,2,5,8,10};
//        int[] sorted = selectSort(testArr);
//        int[] sorted = mergeSort(testArr);
//        int[] sorted = quickSort(testArr, 0, testArr.length - 1);
        int[] sorted = insertSort(testArr);
        System.out.println(sorted);

    }

    public static int[] insertSort(int[] arr){
        if(arr.length < 2){
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp){
                arr[j] = arr[j - 1];
                j--;
            }
            if(j != i){
                arr[j] = tmp;
            }
        }


        return arr;
    }

    public static int[] quickSort(int[] arr, int left, int right){
        if(left < right){
            int parititonIndex = partition(arr, left, right);
            quickSort(arr, left,parititonIndex - 1);
            quickSort(arr, parititonIndex + 1, right);
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


    public static int[] mergeSort(int[] arr){
        if(arr.length < 2){
            return arr;
        }
        int middle = (int)Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return mSort(mergeSort(left), mergeSort(right));
    }

    public static int[] mSort(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int index = 0;
        while (left.length > 0 && right.length > 0){
            if(left[0] < right[0]){
                result[index] = left[0];
                index ++;
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[index] = right[0];
                index ++;
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        if(left.length > 0){
            for (int i = 0; i < left.length; i++) {
                result[index] = left[i];
                index ++;
            }
        }

        if(right.length > 0){
            for (int i = 0; i < right.length; i++) {
                result[index] = right[i];
                index ++;
            }
        }

        return result;
    }

    public static int[] selectSort(int[] arr){
        if(arr.length < 2){
            return arr;
        }

        int curIndex = 0;
        while (curIndex < arr.length - 1){
            for (int i = curIndex + 1; i < arr.length; i++) {
                if(arr[i] < arr[curIndex]){
                    swap(arr, i, curIndex);
                }
            }

            curIndex ++;
        }
        return arr;
    }

    public static int[] swap(int[] arr, int indexA, int indexB){
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
        return arr;
    }
}
