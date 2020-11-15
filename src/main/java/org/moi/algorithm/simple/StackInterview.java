package org.moi.algorithm.simple;

import java.util.Stack;

/**
 * @program:
 * @description: 栈的一道面试题
 * @author: moi
 * @create: 2020/11/15 22:11
 **/
public class StackInterview {

    /**
     * 题目详细：实现一个特殊的栈，加一个查找最小元素的功能
     */

    /**
     * 特殊栈
     */
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack(){
            stackData = new Stack<Integer>();
            //依次存已插入数据的最小值
            stackMin = new Stack<Integer>();
        }

        /**
         * 此方法就能得到栈中最小元素
         * @return
         */
        public int getMin(){
            return stackMin.peek();
        }

        /**
         * 插入数据的时候将另外一个栈也插入数据
         * @param value
         */
        public void push(int value){
            //
            if(this.stackMin.isEmpty()){
                stackMin.push(value);
            }else if(value < stackMin.peek()){
                stackMin.push(value);
            }else{
                int min = stackMin.peek();
                stackMin.push(min);
            }
            stackData.push(value);
        }

        public int pop(){
            int ans = stackData.pop();
            stackMin.pop();
            return ans;
        }
    }

    public static void TestMyStack(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(0);
        myStack.push(5);
        System.out.println(myStack.getMin());

    }

    public static void main(String[] args) {
        TestMyStack();
    }

}
