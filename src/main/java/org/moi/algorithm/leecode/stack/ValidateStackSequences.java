package org.moi.algorithm.leecode.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program:
 * @description: leeCode 第 946 题 验证栈序列
 * @author: moi
 * @create: 2020/12/11 22:45
 **/
public class ValidateStackSequences {

    /**
     * 题目：给定?pushed?和?popped?两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false?。
     *
     *
     */

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = popped.length;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0;i<len;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == len;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        validateStackSequences(pushed,popped);
    }
}
