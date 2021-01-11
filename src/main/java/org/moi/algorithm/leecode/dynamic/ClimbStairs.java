package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description: 70. ��¥�� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/11 21:00
 **/
public class ClimbStairs {

    /**
     * ��Ŀ��������������¥�ݡ���Ҫ n?������ܵ���¥����
     *
     * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
     *
     * ע�⣺���� n ��һ����������
     *
     * ʾ�� 1��
     *
     * ���룺 2
     * ����� 2
     * ���ͣ� �����ַ�����������¥����
     * 1.  1 �� + 1 ��
     * 2.  2 ��
     *
     * ˼·���ö�̬�滮��
     *
     */

    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp = new int[n+1];
        //��ʼ��
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
