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

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums,0,maxF,0,len);
        System.arraycopy(nums,0,minF,0,len);
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(nums[i],nums[i]*minF[i-1]));
            minF[i] = Math.min(minF[i-1]*nums[i],Math.min(nums[i],nums[i]*maxF[i-1]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,maxF[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

}
