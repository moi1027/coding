package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: leeCode �� 922 �� ����ż�������� II �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/7 21:56
 **/
public class SortArrayByParityII {

    /**
     * ��Ŀ������һ���Ǹ���������?A�� A ��һ��������������һ��������ż����
     *
     * ��������������Ա㵱?A[i] Ϊ����ʱ��i?Ҳ����������?A[i]?Ϊż��ʱ�� i Ҳ��ż����
     *
     * ����Է����κ���������������������Ϊ�𰸡�
     *
     *
     * ˼·����˫ָ��ȥ���
     */

    public static int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }



    public static void main(String[] args) {
        int[] arr = {648,831,560,986,192,424,997,829,897,843};
        sortArrayByParityII(arr);
    }
}
