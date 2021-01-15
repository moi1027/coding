package org.moi.algorithm.leecode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: 128. 最长连续序列 难度：hard
 * @author: moi
 * @create: 2021/1/15 23:05
 **/
public class LongestConsecutive {

    /**
     * 题目：给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * ?
     *
     * 进阶：你可以设计并实现时间复杂度为?O(n) 的解决方案吗？
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     *
     */

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]+1){
                num++;
            }else if(nums[i]==nums[i-1]){

            }else{
                max = Math.max(max,num);
                num = 1;
            }
        }
        max = Math.max(max,num);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(new LongestConsecutive().longestConsecutive(arr));
    }
}
