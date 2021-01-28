package org.moi.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:
 * @description: 66. ��һ �y�ȣ�easy
 * @author: moi
 * @create: 2021/1/28 22:06
 **/
public class PlusOne {

    /**
     * �}Ŀ������һ���� ���� ��ɵ� �ǿ� ��������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
     *
     * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
     *
     * ����Լ���������� 0 ֮�⣬��������������㿪ͷ��
     *
     * ?
     *
     * ʾ��?1��
     *
     * ���룺digits = [1,2,3]
     * �����[1,2,4]
     * ���ͣ����������ʾ���� 123��
     *
     */


    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < digits.length; i++) {
            stack.add(digits[i]);
        }
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        if(stack.peek()+1>9){
            stack.pop();
            if(stack.isEmpty()){
                list.add(0);
                list.add(1);
            }else {
                list.add(0);
            }
            flag = 1;
        }else{
            list.add(stack.pop()+1);
        }
        while(!stack.isEmpty()){
            if(stack.peek()+flag>9){
                flag = 1;
                stack.pop();
                if(stack.isEmpty()){
                    list.add(0);
                    list.add(1);
                }else {
                    list.add(0);
                }
            }else{
                list.add(stack.pop()+flag);
                flag = 0;
            }
        }
        int[] res = new int[list.size()];
        int l = res.length;
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(l-1-i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {9,8,9};
        new PlusOne().plusOne1(arr);
    }
}
