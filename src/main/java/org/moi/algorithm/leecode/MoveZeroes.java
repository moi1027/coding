package org.moi.algorithm.leecode;

/**
 * @program:
 * @description: leeCode 第283题 移动0 难度：easy
 * @author: moi
 * @create: 2020/11/19 9:50
 **/
public class MoveZeroes {

    /**
     * leeCode 每日一题： 2020-11-19 时间复杂度O(n)
     * 题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     *
     * 解法：用双指针来解决
     */

    public static void moveZeroes(int[] nums) {
        if(nums.length == 0){
            return;
        }
        int left = 0,right = 0;
        while(right<nums.length){
            if(nums[left] == 0 && nums[right] != 0){
                nums[left] = nums[left]^nums[right];
                nums[right] = nums[left]^nums[right];
                nums[left] = nums[left]^nums[right];
                left++;
            }else if(nums[left]!=0){
                left++;
            }
            right++;
        }
        for(int i:nums){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        moveZeroes(nums);
    }
}
