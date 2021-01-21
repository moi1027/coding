package org.moi.algorithm.simple.classic;

/**
 * @program:
 * @description: N�ʺ�����
 * @author: moi
 * @create: 2021/1/16 23:05
 **/
public class NQueen {

    /**
     * N�ʺ��壺��һ��N*N�������ϣ���N���ʺ�ÿ�����ʺ󶼲�ͬ�в�ͬ�С���ͬб��
     *          ���ж����ְڷ�
     */


    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // record[0] ?  record[1]  ?  record[2]
        int[] record = new int[n]; // record[i] -> i�еĻʺ󣬷����˵ڼ���
        return process1(0, record, n);
    }

    // Ǳ̨�ʣ�record[0..i-1]�Ļʺ��κ������ʺ�һ���������С������У�����б��
    // Ŀǰ�����˵�i��
    // record[0..i-1]��ʾ֮ǰ���У����˵Ļʺ�λ��
    // n��������һ���ж�����  0~n-1��
    // ����ֵ�ǣ��������еĻʺ󣬺����İڷ��ж�����
    public static int process1(int i, int[] record, int n) {
        if (i == n) { // ��ֹ��
            return 1;
        }
        // û�е���ֹλ�ã����лʺ�Ҫ��
        int res = 0;
        for (int j = 0; j < n; j++) { // ��ǰ����i�У�����i�����е���  -> j
            // ��ǰi�еĻʺ󣬷���j�У��᲻���֮ǰ(0..i-1)�Ļʺ󣬲����й��л��߹�б�ߣ�
            // ����ǣ���Ϊ��Ч
            // ������ǣ���Ϊ��Ч
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // record[0..i-1]����Ҫ����record[i...]����Ҫ��
    // ����i�лʺ󣬷�����j�У��Ƿ���Ч
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { // ֮ǰ��ĳ��k�еĻʺ�
            // k, record[k]   i, j
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(num1(n));
    }

}