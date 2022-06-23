package com.lwq.algorithm;

import java.util.Arrays;

/**
 * @author liwenqi
 */
public class No2Sort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 4, 4, 6, 4, 3};

        System.out.println(Arrays.toString(insertSorting(arr)));
    }

    /**
     * 插入排序
     */
    public static int[] insertSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //如果比tmp大把值往后移动一位
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    System.out.println(Arrays.toString(arr));
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;

        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }
}
