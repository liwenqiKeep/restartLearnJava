package com.lwq.algorithm;


/**
 * @author liwenqi
 * 动态规划示例
 */
public class _0001_DynamicProgramming {
    public static void main(String[] args) {

        // 示例1 斐波拉契数列
        int num = 6;
        _1_FibonacciSequenceRecursion(num);
        System.out.println();
        _1_FibonacciSequenceDp(num);
    }


    /**
     * 示例1： 递归实现
     */
    public static int _1_FibonacciSequenceRecursion(int num) {
        if (num < 1) {
            return 0;
        }
        if (num == 1 || num == 2) {
            System.out.print(1 + "  ");
            return 1;
        }
        int a = _1_FibonacciSequenceRecursion(num - 1) + _1_FibonacciSequenceRecursion(num - 2);
        System.out.print(a + "  ");
        return a;
    }

    /**
     * 动态规划实现
     */
    public static int _1_FibonacciSequenceDp(int num) {
        // 1 定义 f(i)
        int[] arr = new int[num + 1];

        // 2 初始化
        arr[0] = 0;
        if (num < 1) {
            return arr[0];
        }
        arr[1] = 1;
        if (num == 1) {
            return arr[1];
        }
        arr[2] = 1;

        // 3 状态递推
        for (int i = 3; i < num + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        // 展示运算过程
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        // 4 返回f(n)
        return arr[num];
    }
}
