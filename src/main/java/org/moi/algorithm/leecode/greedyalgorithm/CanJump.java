package org.moi.algorithm.leecode.greedyalgorithm;

/**
 * @program:
 * @description: 55. 跳跃游戏 难度：medium
 * @author: moi
 * @create: 2020/12/28 22:13
 **/
public class CanJump {

    /**
     * 题目：给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     */

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] jump = {2,5,0,0};
        System.out.println(canJump(jump));


    }
}
