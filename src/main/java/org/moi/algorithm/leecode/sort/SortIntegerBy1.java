package org.moi.algorithm.leecode.sort;

import java.util.*;

/**
 * @program:
 * @description: leeCode 1356  �������ֶ������� 1 ����Ŀ���� �Ѷȣ� easy
 * @author: moi
 * @create: 2020/12/4 22:59
 **/
public class SortIntegerBy1 {

    /**
     * ��Ŀ������һ����������?arr?�����㽫�����е�Ԫ�ذ���������Ʊ�ʾ������ 1 ����Ŀ��������
     *
     * ������ڶ�����ֶ�������?1?����Ŀ��ͬ������뽫���ǰ�����ֵ��С�������С�
     *
     * ���㷵�����������顣
     *
     * ˼·������ÿ��ʮ������ת�������������� 1 �ĸ���
     */

    public static int[] sortByBits(int[] arr) {
        //��ĿҪ��������������500
        int[] count = new int[500];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            list.add(arr[i]);
            count[i] = countBy1(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(count[o1]!=count[o2]){
                    return count[o1]>count[o2]?1:-1;
                }else{
                    return o1>o2?1:-1;
                }
            }
        });
        for(int i = 0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        return  arr;
    }

    //����1�ĸ���
    public static int countBy1(int num){
        int res = 0;
        while(num!= 0){
            res += num % 2;
            num =num/2;
        }
        return res;
    }
}
