package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program:
 * @description: leeCode 1288 ɾ������������
 * @author: moi
 * @create: 2020/12/16 21:59
 **/
public class RemoveCoveredIntervals {

    /**
     * ��Ŀ������һ�������б�����ɾ���б��б��������������ǵ����䡣
     *
     * ֻ�е�?c <= a?��?b <= d?ʱ�����ǲ���Ϊ����?[a,b) ������?[c,d) ���ǡ�
     *
     * ���������ɾ�����������㷵���б���ʣ���������Ŀ��
     *
     *
     */

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //�Ƚ�ÿ������ĵ�һ������ȣ��򰴵ڶ���Ľ������У����������򰴵�һ�����������
                return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });
        int pre_end = 0;
        int count = 0;
        int end = 0;
        for(int[] arr: intervals){
            end = arr[1];
            if(pre_end<end){
                count++;
                pre_end = end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] s =  {{1,4},{3,6},{2,8}};
        removeCoveredIntervals(s);
    }
}
