package org.moi.algorithm.leecode.stack;

import java.util.Stack;

/**
 * @program:
 * @description: 155. 最小栈 难度：easy
 * @author: moi
 * @create: 2021/1/20 21:25
 **/
public class MinStack {

    private Stack<Integer> stack ;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if(!minStack.isEmpty()&&minStack.peek()<=x){
            minStack.add(minStack.peek());
        }else{
            minStack.add(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
