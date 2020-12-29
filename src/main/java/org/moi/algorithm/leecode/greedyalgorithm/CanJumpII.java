package org.moi.algorithm.leecode.greedyalgorithm;

/**
 * @program:
 * @description: 45. 跳跃游戏 II 难度：hard
 * @author: moi
 * @create: 2020/12/29 21:13
 **/
public class CanJumpII {

    /**
     * 题目：给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 示例:
     *
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * ?    从下标为 0 跳到下标为 1 的位置，跳?1?步，然后跳?3?步到达数组的最后一个位置。
     * 说明:
     *
     * 假设你总是可以到达数组的最后一个位置。
     *
     *
     */

    public int jump(int[] nums) {
        int length = nums.length;
        int steps = 0;
        int end = 0;
        int tmp = 0;
        for(int i = 0;i < length-1;i++){
            tmp = Math.max(tmp,i+nums[i]);
            if(i == end){
                end = tmp;
                steps++;
            }
        }
        return steps;
    }
}
