package org.moi.algorithm.leecode.sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program:
 * @description: 84. ��״ͼ�����ľ��� �Ѷȣ�hard
 * @author: moi
 * @create: 2021/1/12 21:28
 **/
public class LargestRectangleArea {

    /**
     * ��Ŀ������ n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
     *
     * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
     *
     * ��������״ͼ��ʾ��������ÿ�����ӵĿ��Ϊ 1�������ĸ߶�Ϊ [2,1,5,6,2,3]��
     */




    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length+2];
        System.arraycopy(heights,0,tmp,1,heights.length);
        Deque<Integer> deque = new LinkedList<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < tmp.length; i++) {
            while(!deque.isEmpty()&&tmp[i]<tmp[deque.peek()]){
                int height = tmp[deque.pop()];
                maxArea = Math.max(maxArea,(i-deque.peek()-1)*height);
            }
            deque.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        new LargestRectangleArea().largestRectangleArea(arr);
    }
}
