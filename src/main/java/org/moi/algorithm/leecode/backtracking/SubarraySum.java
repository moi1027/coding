package org.moi.algorithm.leecode.backtracking;

import java.util.Stack;

/**
 * @program:
 * @description: 560. 和为K的子数组 难度：medium
 * @author: moi
 * @create: 2021/1/24 20:50
 **/
public class SubarraySum {

    /**
     * 题目：给定一个整数数组和一个整数?k，你需要找到该数组中和为?k?的连续的子数组的个数。
     *
     * 示例 1 :
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     *
     *
     */

    int count = 0;
    public int subarraySum(int[] nums, int k) {
        if(nums == null){
            return count;
        }
        for (int i = 0; i <nums.length ; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp+=nums[j];
                if(tmp == k){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {-92,-63,75,-86,-58,22,31,-16,-66,-67,420};
        System.out.println(new SubarraySum().subarraySum(arr,100));
    }
}
