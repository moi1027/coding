package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description:  121. ������Ʊ�����ʱ�� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/15 22:13
 **/
public class MaxProfit {

    /**
     * ��Ŀ������һ�����飬���ĵ�?i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
     *
     * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊһ�Σ������һ���㷨�����������ܻ�ȡ���������
     *
     * ע�⣺�㲻���������Ʊǰ������Ʊ��
     *
     * ?
     *
     * ʾ�� 1:
     *
     * ����: [7,1,5,3,6,4]
     * ���: 5
     * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     *      ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�ͬʱ���㲻��������ǰ������Ʊ��
     *
     *
     */

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
