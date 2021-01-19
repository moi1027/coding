package org.moi.algorithm.leecode.backtracking;

/**
 * @program:
 * @description: 152. 乘积最大子数组 难度：medium
 * @author: moi
 * @create: 2021/1/19 22:05
 **/
public class MaxProduct {

    /**
     * 题目：给你一个整数数组 nums?，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * ?
     *
     * 示例 1:
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释:?子数组 [2,3] 有最大乘积 6。
     *
     *
     */

    int max = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            max = Math.max(max,count);
            for (int j = i+1; j < nums.length; j++) {
                count *=nums[j];
                max = Math.max(max,count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

}
