package org.moi.algorithm.leecode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description: 84. 柱状图中最大的矩形 难度：hard
 * @author: moi
 * @create: 2021/1/12 21:28
 **/
public class LargestRectangleArea {

    /**
     * 题目：给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     */




    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length+2];
        System.arraycopy(heights,0,tmp,1,heights.length);
        Deque<Integer> deque = new LinkedList<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < tmp.length; i++) {
            while(!deque.isEmpty()&&tmp[i]<tmp[deque.peek()]){
                int height = tmp[deque.pop()];
                maxArea = Math.max(maxArea,(i-deque.peek()-1)*height);
            }
            deque.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        new LargestRectangleArea().largestRectangleArea(arr);
    }
}
