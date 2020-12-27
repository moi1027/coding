package org.moi.algorithm.leecode.greedyalgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program:
 * @description: 122. ������Ʊ�����ʱ�� II �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/27 23:35
 **/
public class MaxProfit {

    /**
     * ��Ŀ������һ�����飬���ĵ�?i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
     *
     * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
     *
     * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
     *
     * ʾ�� 1:
     *
     * ����: [7,1,5,3,6,4]
     * ���: 7
     * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
     * ?    ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6-3 = 3 ��
     * ʾ�� 2:
     *
     * ����: [1,2,3,4,5]
     * ���: 4
     * ����: �ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
     * ?    ע���㲻���ڵ� 1 ��͵� 2 ����������Ʊ��֮���ٽ�����������
     * ?    ��Ϊ��������ͬʱ�����˶�ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ��
     * ʾ��?3:
     *
     * ����: [7,6,4,3,1]
     * ���: 0
     * ����: �����������, û�н������, �����������Ϊ 0��
     *
     *˼·����̰��
     */



    static class DataInfo{
        private int price;
        private int day;
        public DataInfo(int p,int d){
            price = p;
            day = d;
        }
    }

    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        //����һ��С����
        PriorityQueue<DataInfo> priorityQueue = new PriorityQueue<>(new Comparator<DataInfo>() {
            @Override
            public int compare(DataInfo o1, DataInfo o2) {
                if(o1.price<o2.price){
                    return o2.day-o1.day;
                }else{
                    return o1.day-o2.day;
                }
            }
        });
        PriorityQueue<DataInfo> priorityQueue1 = new PriorityQueue<>(new Comparator<DataInfo>() {
            @Override
            public int compare(DataInfo o1, DataInfo o2) {
                if(o2.price>=o1.price){
                    if(o2.day>o1.day){
                        return o2.day-o1.day;
                    }else{
                        return o2.day-o1.day;
                    }
                }else{
                    return o2.day-o1.day;
                }
            }
        });
        int j = 1;
        for(int i:prices){
            priorityQueue.add(new DataInfo(i,j++));
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        maxProfit(arr);
    }
}
