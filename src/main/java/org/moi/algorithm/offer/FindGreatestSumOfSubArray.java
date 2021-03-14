package org.moi.algorithm.offer;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Map;

/**
 * @program:
 * @description: ���������������
 * @author: moi
 * @create: 2021/3/14 23:04
 **/
@Ignore
public class FindGreatestSumOfSubArray {

    /**
     * ��Ŀ: ��ָoffer ����һ���������飬������������Ҳ�и����������е�һ������������������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�Ϊ O(n).
     *
     * �ⷨ���ö�̬�滮ȥ�⣬ÿ����
     */

    public static int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i-1]>0?array[i-1]:0;
            max = Math.max(max,array[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
