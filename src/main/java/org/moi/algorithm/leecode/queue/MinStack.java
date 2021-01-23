package org.moi.algorithm.leecode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description: ��ָ offer ����min������ջ �Ѷȣ� easy
 * @author: moi
 * @create: 2020/12/8 21:23
 **/
public class MinStack {

    /**
     * ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min �����ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
     *
     *
     * ʾ����
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> ���� -3.
     * minStack.pop();
     * minStack.top();      --> ���� 0.
     * minStack.min();   --> ���� -2.
     *
     */


    /**
     * �����������ջ
     */
    Deque<Integer> d1;
    /**
     * ���ջ�洢d1ջ�е���Сֵ
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
