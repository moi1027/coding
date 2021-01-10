package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 48. ��תͼ�� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/10 21:58
 **/
public class Rotate {

    /**
     * ��Ŀ������һ�� n?��?n �Ķ�ά�����ʾһ��ͼ��
     *
     * ��ͼ��˳ʱ����ת 90 �ȡ�
     *
     * ˵����
     *
     * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
     *
     * ʾ�� 1:
     *
     * ���� matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * ԭ����ת�������ʹ���Ϊ:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * ˼·���ҹ���
     */

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int n = len-1;
        int[][] tmpNum = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                tmpNum[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = tmpNum[len-1-j][i];
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        new Rotate().rotate(nums);
    }
}
