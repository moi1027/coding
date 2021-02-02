package org.moi.algorithm.simple.classic;

import java.util.ArrayList;
import java.util.List;

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


    public static List<List<String>> lists = new ArrayList<>();

    public static List<List<String>> num1(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        // record[0] ?  record[1]  ?  record[2]
        int[] record = new int[n]; // record[i] -> i�еĻʺ󣬷����˵ڼ���
        process1(0, record, n);
        return lists;
    }

    // Ǳ̨�ʣ�record[0..i-1]�Ļʺ��κ������ʺ�һ���������С������У�����б��
    // Ŀǰ�����˵�i��
    // record[0..i-1]��ʾ֮ǰ���У����˵Ļʺ�λ��
    // n��������һ���ж�����  0~n-1��
    // ����ֵ�ǣ��������еĻʺ󣬺���İڷ��ж�����
    public static int process1(int i, int[] record, int n) {
        if (i == n) { // ��ֹ��
            StringBuffer sb = new StringBuffer();
            List<String> strings = new ArrayList<>();
            for (int j = 0; j < record.length; j++) {
                for (int k = 0; k < record[j]; k++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int k = record[j]+1; k < n; k++) {
                    sb.append(".");
                }
                strings.add(sb.toString());
                sb = new StringBuffer();
            }
            lists.add(strings);
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
        int n = 1;
        System.out.println(num1(n));
    }

}
