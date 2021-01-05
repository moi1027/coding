package org.moi.algorithm.leecode.doublepointer;

/**
 * @program:
 * @description: 11. 盛最多水的容器 难度：medium
 * @author: moi
 * @create: 2021/1/5 20:51
 **/
public class ContainerWithMostWater {

    /**
     * 题目：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0) 。找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为?49。
     *
     *
     *
     * 思路：用双指针来写
     */

    public int maxArea(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*Math.abs(left-right));
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        new ContainerWithMostWater().maxArea(nums);
    }
}
