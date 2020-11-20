package org.moi.algorithm.leecode;

import java.util.Stack;

/**
 * @program:
 * @description: leeCode 第503题 下一个更大元素 II 难度 中等
 * @author: moi
 * @create: 2020/11/20 15:23
 **/
public class NextGreaterElement2 {
    /**
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     *
     */

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] nums2 = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        //由于是循环数组所以需要将长度加长到两倍
        for(int i = 2*len-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums[i]){
                stack.pop();
            }
            nums2[i%len] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }

        return nums2;
    }
}
