package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 238. 除自身以外数组的乘积 难度：medium
 * @author: moi
 * @create: 2021/1/22 22:39
 **/
public class ProductExceptSelf {

    /**
     * 题目：给你一个长度为?n?的整数数组?nums，其中?n > 1，返回输出数组?output?，其中 output[i]?等于?nums?中除?nums[i]?之外其余各元素的乘积。
     *
     * ?
     *
     * 示例:
     *
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     *
     *
     */

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1]*nums[i];
        }
        for (int i = len-2; i >=0 ; i--) {
            right[i] = right[i+1]*right[i];
        }
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,0};
        new ProductExceptSelf().productExceptSelf(nums);
    }
}
