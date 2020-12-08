package org.moi.algorithm.leecode.stack;

import java.util.Stack;

/**
 * @program:
 * @description: 面试题 17.21 直方图的水量  难度：hard
 * @author: moi
 * @create: 2020/12/8 22:15
 **/
public class VolumeOfHistogramLCCI {
    /**
     * 题目：给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
     *
     * 思路：用单调栈来解决，为接雨水问题
     */

    /**
     * 内部有一个单调栈，内部的这个单调栈是的每个元素都是递减的，如果出现比栈顶元素大的元素，则出栈直到栈顶元素大于即将入栈的元素
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int popnum = stack.pop();
                while(!stack.isEmpty()&& height[stack.peek()]==height[popnum]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    int tmp = height[stack.peek()];
                    int h = Math.min(tmp-height[popnum],height[i] - height[popnum]);
                    int w = i-stack.peek()-1;
                    water+=h*w;
                }
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
