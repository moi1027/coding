package org.moi.algorithm.leecode;

import java.util.Stack;

/**
 * @program:
 * @description: leeCode 第1118题 一月有多少天 难度 中级
 * @author: moi
 * @create: 2020/11/20 15:47
 **/
public class DailyTemperatures {

    /**
     * 题目 给你一个数组T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
     *
     *
     * 解法：用单调栈解决
     */

    public static int[] dailyTemperatures(int[] nums){
        int len = nums.length;
        int[] nums2 = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        //由于是判断隔几天，所以就用下标来标记
        for(int i = len -1;i>=0;i--){
            if(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            nums2[i] = stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return nums2;
    }

    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,76};
        dailyTemperatures(nums);
    }
}
