package org.moi.algorithm.leecode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description: 剑指 offer 包含min函数的栈 难度： easy
 * @author: moi
 * @create: 2020/12/8 21:23
 **/
public class MinStack {

    /**
     * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     *
     *
     * 示例：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     *
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
    public MinStack() {
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
}
