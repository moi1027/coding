package org.moi.algorithm.leecode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description: ���������Сֵ֮�� leeCode 907 �Ѷȣ� medium
 * @author: moi
 * @create: 2020/12/12 23:38
 **/
public class SumOfSubarrayMinimums {

    /**
     * ��Ŀ������һ���������� A���ҵ� min(B) ���ܺͣ����� B �ķ�ΧΪ A ��ÿ���������������顣
     *
     * ���ڴ𰸿��ܴܺ���˷��ش�ģ 10^9 + 7��
     * 
     * 
     * ʾ����
     * ���룺[3,1,2,4]
     * �����17
     * ���ͣ�
     * ������Ϊ [3]��[1]��[2]��[4]��[3,1]��[1,2]��[2,4]��[3,1,2]��[1,2,4]��[3,1,2,4]��
     * ��СֵΪ 3��1��2��4��1��1��2��1��1��1����Ϊ 17��
     *
     *˼·������С����ջ���
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
