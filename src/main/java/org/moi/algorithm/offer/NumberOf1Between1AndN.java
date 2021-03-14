package org.moi.algorithm.offer;

/**
 * @program:
 * @description: ������1���ֵĴ���
 * @author: moi
 * @create: 2021/3/14 23:29
 **/
public class NumberOf1Between1AndN {

    /**
     * ��Ŀ����ָoffer:���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
     */

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <=n; i++) {
            count+=fun(i);
        }
        return count;
    }

    public int fun(int n){
        String s = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                res++;
            }
        }
        return res;
    }
}
