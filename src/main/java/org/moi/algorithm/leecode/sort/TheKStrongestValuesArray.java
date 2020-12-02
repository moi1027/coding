package org.moi.algorithm.leecode.sort;

import java.util.*;

/**
 * @program:
 * @description: leeCode  1471 �����е� k ����ǿֵ �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/2 21:59
 **/
public class TheKStrongestValuesArray {

    /**
     * ����һ���������� arr ��һ������ k ��
     *
     * �� m Ϊ�������λ����ֻҪ������������ǰ��֮һ���Ϳ����ж� arr[i] ��ֵ�� arr[j] ��ֵ��ǿ��
     *
     * ?|arr[i] - m| > |arr[j]?- m|
     * ?|arr[i] - m| == |arr[j] - m|���� arr[i] > arr[j]
     *
     *
     *
     * ˼·�������˼·�����ñȽ����������и��ӣ�ֱ��ʹ��Arrays.sort(),�����������ʹ�ñȽ���һ��Ҫ�Ǽ̳���Object�ķ��ͣ���������ȿ�
     *
     */

    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length-1)/2];
        List<Integer> list = new ArrayList<>();
        for(int i  = 0;i<arr.length;i++){
            list.add(arr[i]);
        }
        //�Զ���Ƚ���
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //����ǴӴ�С���е�
                if(Math.abs(o1-m)>Math.abs(o2-m)){
                    return -1;
                }else if(Math.abs(o1-m)==Math.abs(o2-m)){
                    return o1>o2?-1:1;
                }
                return 1;
            }
        });
        int[] res = new int[k];
        for(int i  = 0;i<k;i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr =  {-7,22,17,3};
        getStrongest(arr,2);
    }

}
