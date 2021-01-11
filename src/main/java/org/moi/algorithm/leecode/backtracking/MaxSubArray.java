package org.moi.algorithm.leecode.backtracking;

/**
 * @program:
 * @description: 53. 最大子序和  难度：easy
 * @author: moi
 * @create: 2021/1/11 10:45
 **/
public class MaxSubArray {
    /**
     * 题目：给定一个整数数组 nums?，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释:?连续子数组?[4,-1,2,1] 的和最大，为?6。
     *
     *
     */

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int num = 0;
            for (int j = i; j < len; j++) {
                max = Math.max(num+=nums[j],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1};
        new MaxSubArray().maxSubArray(arr);
    }
}
