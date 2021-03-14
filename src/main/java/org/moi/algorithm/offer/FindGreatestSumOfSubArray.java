package org.moi.algorithm.offer;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Map;

/**
 * @program:
 * @description: 连续子数组的最大和
 * @author: moi
 * @create: 2021/3/14 23:04
 **/
@Ignore
public class FindGreatestSumOfSubArray {

    /**
     * 题目: 剑指offer 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
     *
     * 解法：用动态规划去解，每个数
     */

    public static int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i-1]>0?array[i-1]:0;
            max = Math.max(max,array[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
