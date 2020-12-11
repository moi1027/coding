package org.moi.algorithm.leecode.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program:
 * @description: leeCode �� 946 �� ��֤ջ����
 * @author: moi
 * @create: 2020/12/11 22:45
 **/
public class ValidateStackSequences {

    /**
     * ��Ŀ������?pushed?��?popped?�������У�ÿ�������е� ֵ�����ظ���ֻ�е����ǿ������������ջ�Ͻ��е����� push �͵��� pop �������еĽ��ʱ������ true�����򣬷��� false?��
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
