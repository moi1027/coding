package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: leeCode 1387 ��������Ȩ������ �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/4 22:26
 **/
public class SortIntegersByThePowerValue {


    /**
     * ��Ŀ�����ǽ����� x?�� Ȩ�� ����Ϊ������������ x?��� 1?����Ҫ�Ĳ�����
     *
     * ���?x?��ż������ô x = x / 2
     * ���?x?����������ô?x = 3 * x + 1
     * �ȷ�˵��x=3 ��Ȩ��Ϊ 7 ����Ϊ 3 ��Ҫ 7 ����� 1 ��3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1����
     *
     * ������������?lo��?hi ��?k?����������ǽ�����?[lo, hi]?֮��������������ǵ�Ȩ��?��������?��������ڵ��� 2 ��������?��ͬ?��Ȩ�أ���ô���������������ֵ?��������?��
     *
     * ���㷵������?[lo, hi]?֮���������Ȩ�������ĵ�?k?������
     *
     * ע�⣬��Ŀ��֤������������?x?��lo <= x <= hi��?�������?1 ����Ҫ�Ĳ�����һ�� 32 λ�з���������
     *
     * ˼·���ñȽ����ķ�ʽ����
     */

    public static int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        int n = lo;
        for(int i = 0;i<=hi-lo;i++){
            list.add(n);
            n++;
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(count(o1,0)>count(o2,0)){
                    return 1;
                }else if(count(o1,0)<count(o2,0)){
                    return -1;
                }else{
                    return o1>o2?1:-1;
                }
            }
        });

        return list.get(k-1);
    }

    public static int count(Integer num,Integer count){
        while(num != 1){
            if(num % 2 == 0){
                num = num/2;
                count++;
            }else if(num % 2 !=0){
                num = 3*num +1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int lo = 1,hi = 1000;
        System.out.println(getKth(lo,hi,777));
    }
}
