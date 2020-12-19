package org.moi.algorithm.leecode.heap;

import java.util.PriorityQueue;

/**
 * @program:
 * @description: ��ָ Offer 41. �������е���λ�� �Ѷȣ� hard
 * @author: moi
 * @create: 2020/12/19 21:37
 **/
public class MedianFinder {


    /**
     * ��Ŀ����εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
     *
     * ˼·���������������������⣬һ���Ǵ�ϴ�ֵ��С���ѣ�һ���Ǵ��Сֵ�Ĵ󶥶ѣ������ѵĴ�С�ڲ��������Ϊ������Ϊż����ʱ��һ��
     */


    /**
     * ����������
     */
    PriorityQueue<Integer> A,B;
    public MedianFinder() {
        //java���ṩ�Ķ�ΪС����
        A = new PriorityQueue<>();
        //ͨ���Ƚ����ķ�ʽ����ת��λ�󶥶�
        B = new PriorityQueue<>((x,y)->(y-x));
    }

    public void addNum(int num) {
        //ΪɶҪ��B����󶥶��Ȳ������ݣ����ڵ������������������ʱ��������ҪȥС���ѵĶ�Ԫ�ص�����λ���������Ȳ���B����󶥶���Ȼ��ȡ���󶥶ѵĶ�Ԫ�ز��뵽A�У���֤��A��B��������ͬ��С������£��´β���A���л��B���ж�һ��Ԫ��
        if(A.size()!=B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size()==B.size()?(A.peek()+B.peek())/2.0:A.peek();
    }


}
