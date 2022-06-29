package com.lwq.algorithm;

import java.util.Arrays;

/**
 * @author liwenqi
 */
public class No2Sort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 4, 4, 6, 4, 3};
//
//        System.out.println(Arrays.toString(insertSorting(arr)));
//
//        System.out.println(Arrays.toString(selSort(arr)));
//
//        System.out.println(Arrays.toString(bubbleSort(arr)));
//
//        System.out.println(Arrays.toString(insertSort(arr)));

        mergeSort(arr);
        System.out.println(Arrays.toString(insertSort(arr)));

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
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;

        }
        return arr;
    }

    public static int[] insertSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i-1; j >=0 && arr[j]>arr[j+1] ; j--) {
                int a = arr[j];
                arr[j+1] = arr[j];
                arr[j] = a;
            }
        }
        return arr;
    }
    public static int[] selSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    /**
     * 二分法
     * 1） 在有序数组中查找某个数是否存在
     * 2） 在一个有序数组中找一个数在最左侧的位置
     *     思路： 继续使用二分 往最左侧二分
     * 3） 局部最小值问题(非有序二分法 可能也是满足的)
     *      思路：
     *       1. 先判断 0 ，n 位置是否为局部最小值
     *       2. 使用二分法，判断是否为局部最小（ \(0)   /(m-1)  (m)  \(m+1)  /(n) ）
     */

    /**
     * 对数器
     * 方法 a （想要测试的方法）
     *
     * 方法 b （暴力求解）
     */


    /**
     * 递归
     *
     * master 公式 求时间复杂度
     *
     * T(N)  = a * T(N/b) + O(N^d)
     *
     * a 为子问题执行次数
     * N 为问题规模
     * d 为 其余过程执行的时间复杂度
     *
     * 1） log(b) a < d     O(N^d)
     * 2） log(b) a = d     O(N ^ (log(b)a))
     * 3） log(b) a > d     O(N^d * ln N )
     *
     * 如下求最大值
     * N= r-l
     * a = 2
     * b = 2
     * d = 0
     * 参考：
     * www.gocalf.com/blog/algorithm-complexity-and-master-theorem.html
     */
    /**
     * 递归求最大值
     *
     */
    public static  int max(int arr[],int l,int r){
        if(l == r){
          return arr[l];

        }
        int mid = l + ((r-l)>>1);
        int leftMax = max(arr,l,mid);
        int rightMax = max(arr,mid+1,r);
        return Math.max(leftMax,rightMax);

    }


    /**
     * 归并排序
     *
     */

     public static void mergeSort(int[] arr){
         if(arr == null || arr.length < 2){
             return ;

         }
         process(arr,0,arr.length -1 );
     }

    private static void process(int[] arr, int i, int i1) {

         if(i == i1){
             return ;
         }
         int mid = i + ((i1 - i)>> 1);
         process(arr,i,mid);
         process(arr,mid + 1 , i1);

         int[] help = new int[i1 - i +1];
         int j = 0;
         int p1 = i;
         int p2 = mid +1;
         while (p1 <= mid && p2 <= i1){
             help[j++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
         }
         while (p1 <= mid ){
             help[j++] = arr[p1++];
         }
         while (p2 <= i1){
             help[j++] = arr[p2++];
         }
        for (int k = 0; k < help.length; k++) {
            arr[i+k] = help[k];
        }
    }


}

