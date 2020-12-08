package org.moi.algorithm.leecode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description: 剑指 offer 9 用两个栈实现队列 难度 easy
 * @author: moi
 * @create: 2020/12/8 20:55
 **/
public class CQueue {
    /**
     * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead?操作返回 -1 )
     *
     */

    /**
     * 正常栈
     */
    Deque<Integer> d1;
    Deque<Integer> d2;

    public CQueue() {
        d1 = new LinkedList<>();
        d2 = new LinkedList<>();

    }

    public void appendTail(int value) {
        d1.push(value);
    }

    public int deleteHead() {
        if(d1.isEmpty()){
            return -1;
        }
        while(!d2.isEmpty()){
            d2.pop();
        }
        while(!d1.isEmpty()){
            d2.push(d1.pop());
        }
        int res = d2.pop();
        while(!d2.isEmpty()){
            d1.push(d2.pop());
        }
        return res;
    }
}
