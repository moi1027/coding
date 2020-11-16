package org.moi.algorithm.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description: 239题，用滑动串口解决
 * @author: moi
 * @create: 2020/11/16 17:32
 **/
public class SlidingWindow {
    /**
     * 给你输入一个数组nums和一个正整数k，有一个大小为k的窗口在nums上从左至右滑动，请你输出每次窗口中k个元素的最大值。
     *
     * 函数签名如下：
     *
     * int[] maxSlidingWindow(int[] nums, int k);
     */



    public static int[] maxSlidingWindow(int[] nums, int k){
        int len = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        MyQueue myQueue = new MyQueue();
        for(int i = 0;i<len;i++){
            if(i<k-1){
                //先插入k-1个数
                myQueue.push(nums[i]);
            }else{
                myQueue.push(nums[i]);
                list.add(myQueue.getMax());
                myQueue.poll(nums[i-k+1]);
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(arr,3).toString());
    }
}


/**
 * 自己定义的一个单调队列用来解决滑动窗口的问题
 */
class MyQueue{
    private LinkedList<Integer> list = new LinkedList<Integer>();

    /**
     * 插入队列的时候要写判断一下数据的大小，保证队列中只存在最大的那个数据
     * @param value
     */
    public void push(int value){
        while (!list.isEmpty() && list.getLast() < value) {
            list.pollLast();
        }
        list.addLast(value);
    }

    public void poll(int value){
        if(value == list.getFirst()){
            list.pollFirst();
        }
    }

    /**
     * 由于队列中只有一个最大的值，所以直接取出就是最大的值
     * @return
     */
    public int getMax(){
        return list.getFirst();
    }
}