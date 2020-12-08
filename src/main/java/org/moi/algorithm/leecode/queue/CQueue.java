package org.moi.algorithm.leecode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program:
 * @description: ��ָ offer 9 ������ջʵ�ֶ��� �Ѷ� easy
 * @author: moi
 * @create: 2020/12/8 20:55
 **/
public class CQueue {
    /**
     * ��Ŀ��������ջʵ��һ�����С����е��������£���ʵ�������������� appendTail �� deleteHead ���ֱ�����ڶ���β�������������ڶ���ͷ��ɾ�������Ĺ��ܡ�(��������û��Ԫ�أ�deleteHead?�������� -1 )
     *
     */

    /**
     * ����ջ
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
