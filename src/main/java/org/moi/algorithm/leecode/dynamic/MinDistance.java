package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description:  72. �༭���� �Ѷȣ�hard
 * @author: moi
 * @create: 2021/1/12 21:03
 **/
public class MinDistance {

    /**
     * ��Ŀ��������������?word1 ��?word2������������?word1?ת����?word2 ��ʹ�õ����ٲ�����?��
     *
     * ����Զ�һ�����ʽ����������ֲ�����
     *
     * ����һ���ַ�
     * ɾ��һ���ַ�
     * �滻һ���ַ�
     * ?
     *
     * ʾ��?1��
     *
     * ���룺word1 = "horse", word2 = "ros"
     * �����3
     * ���ͣ�
     * horse -> rorse (�� 'h' �滻Ϊ 'r')
     * rorse -> rose (ɾ�� 'r')
     * rose -> ros (ɾ�� 'e')
     *
     *
     */

    public int minDistance(String word1, String word2) {
        int xLen = word1.length();
        int yLen = word2.length();
        int[][] dp = new int[xLen+1][yLen+1];
        for (int i = 0; i <= xLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= yLen; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(word2.charAt(i-1) == word1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }
        return dp[xLen][yLen];
    }
}
