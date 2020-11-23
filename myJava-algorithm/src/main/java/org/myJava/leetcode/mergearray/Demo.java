package org.myJava.leetcode.mergearray;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class Demo {


    public static void main(String[] args) {
        int[] arrayOne = new int[]{1, 2, 3, 0, 0, 0};
        int[] arrayTwo = new int[]{2, 5, 6};

        List<String> alist = new ArrayList<String>();
        alist.add(null);
        alist.add("1");

        System.out.println(alist.parallelStream().map(element -> {
            if (null == element) {
                return "2";
            }
            return element;
        }).collect(Collectors.toList()));
        System.out.println(alist);

        mergeArray(arrayOne, arrayTwo);
        //merge(arrayOne, arrayOne.length, arrayTwo, arrayTwo.length);
        //sort(arrayOne, arrayTwo);
        mergeArray(arrayOne, arrayOne.length, arrayTwo, arrayTwo.length);
        List<String> list = new ArrayList<String>();
        list.add(1, "");
    }

    private static void mergeArray(int[] one, int[] two) {
        int indexTwo = 0;
        int size = one.length;
        //for (int i = 0; i < one.length; i++) {
        //    int oneTmpValue = one[i];
        //    for (int j = indexTwo; j < two.length; indexTwo++) {
        //        if (oneTmpValue >= two[indexTwo]) {
        //            System.arraycopy(one, i, one, i + 1, size - i - 1);
        //            one[i] = two[indexTwo];
        //            i++;
        //            break;
        //        } else if (oneTmpValue < two[indexTwo]) {
        //
        //        } else if (oneTmpValue == 0) {
        //            one[i] = two[indexTwo];
        //            indexTwo++;
        //            break;
        //        } else {
        //            break;
        //        }
        //    }
        //}
        for (int i = 0; i < one.length; i++) {
            int oneTmpValue = one[i];
            for (int j = indexTwo; j < two.length; j++) {
                if(oneTmpValue < two[indexTwo]){
                    one[i] = two[indexTwo];
                    int tmp = one[i + 1];
                    one[i + 1] = oneTmpValue;
                    oneTmpValue = tmp;
                } else if(oneTmpValue >= two[indexTwo]) {
                    break;
                }
            }
        }
        System.out.println(one);
    }

    public static void mergeArray(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        if (i != m) {
            while (i < m) {
                result[k++] = nums1[i++];
            }
        }
        if (j != n) {
            while (j < n) {
                result[k++] = nums2[j++];
            }
        }
        k = 0;
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = result[k++];
        }
        System.out.println();
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        // if there are still elements to add
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
        System.out.println();
    }

    public static int[] sort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] >= b[j]) {
                c[k++] = b[j++];
            } else {
                c[k++] = a[i++];
            }
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        return c;

    }
}
