package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: leeCode 第 922 题 按奇偶排序数组 II 难度：easy
 * @author: moi
 * @create: 2020/12/7 21:56
 **/
public class SortArrayByParityII {

    /**
     * 题目：给定一个非负整数数组?A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当?A[i] 为奇数时，i?也是奇数；当?A[i]?为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     *
     * 思路：用双指针去解决
     */

    public static int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }



    public static void main(String[] args) {
        int[] arr = {648,831,560,986,192,424,997,829,897,843};
        sortArrayByParityII(arr);
    }
}
