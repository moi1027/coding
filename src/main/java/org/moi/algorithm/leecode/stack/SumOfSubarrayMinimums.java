package org.moi.algorithm.leecode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description: 子数组的最小值之和 leeCode 907 难度： medium
 * @author: moi
 * @create: 2020/12/12 23:38
 **/
public class SumOfSubarrayMinimums {

    /**
     * 题目：给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
     *
     * 由于答案可能很大，因此返回答案模 10^9 + 7。
     * 
     * 
     * 示例：
     * 输入：[3,1,2,4]
     * 输出：17
     * 解释：
     * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
     * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
     *
     *思路：用最小数字栈解决
     */
    /**
     * 这个是正常的栈
     */
    Deque<Integer> d1;
    /**
     * 这个栈存储d1栈中的最小值
     */
    Deque<Integer> d2;
    /** initialize your data structure here. */
    public SumOfSubarrayMinimums() {
        d1 = new LinkedList<>();
        d2 = new LinkedList<>();
    }

    public void push(int x) {
        d1.push(x);
        if(d2.isEmpty()){
            d2.push(x);
        }else{
            if(d2.peek() > x){
                d2.push(x);
            }else{
                d2.push(d2.peek());
            }
        }
    }

    public void pop() {
        d1.pop();
        d2.pop();
    }

    public int top() {
        return d1.peek();
    }

    public int min() {
        return d2.peek();
    }

    public int sumSubarrayMins(int[] arr) {
        int count = 0;
        SumOfSubarrayMinimums s = new SumOfSubarrayMinimums();
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j+=i){
                s.push(arr[i]);
            }

        }
        return count;
    }




}
