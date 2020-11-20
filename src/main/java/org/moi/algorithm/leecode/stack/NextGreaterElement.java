package org.moi.algorithm.leecode.stack;

import java.util.Stack;

/**
 * @program:
 * @description: leeCode 第496题 下一个更大元素 I 难度 easy
 * @author: moi
 * @create: 2020/11/20 12:05
 **/
public class NextGreaterElement {

    /**
     * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     *
     *
     */

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        int[] nums3 = new int[len];
        int[] nums4 = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = len-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            nums3[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums2[i]);
        }
        for(int j = 0;j<nums1.length;j++){
            for(int i = 0;i<len;i++){
                if(nums1[j] == nums2[i]){
                    nums4[j] = nums3[i];
                    break;
                }
            }
        }
        return nums4;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }
}
