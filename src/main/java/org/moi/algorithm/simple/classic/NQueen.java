package org.moi.algorithm.simple.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: N皇后问题
 * @author: moi
 * @create: 2021/1/16 23:05
 **/
public class NQueen {

    /**
     * N皇后定义：在一个N*N的棋盘上，有N个皇后，每两个皇后都不同行不同列、不同斜线
     *          求有多少种摆法
     */


    public static List<List<String>> lists = new ArrayList<>();

    public static List<List<String>> num1(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        // record[0] ?  record[1]  ?  record[2]
        int[] record = new int[n]; // record[i] -> i行的皇后，放在了第几列
        process1(0, record, n);
        return lists;
    }

    // 潜台词：record[0..i-1]的皇后，任何两个皇后一定都不共行、不共列，不共斜线
    // 目前来到了第i行
    // record[0..i-1]表示之前的行，放了的皇后位置
    // n代表整体一共有多少行  0~n-1行
    // 返回值是，摆完所有的皇后，合理的摆法有多少种
    public static int process1(int i, int[] record, int n) {
        if (i == n) { // 终止行
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
        // 没有到终止位置，还有皇后要摆
        int res = 0;
        for (int j = 0; j < n; j++) { // 当前行在i行，尝试i行所有的列  -> j
            // 当前i行的皇后，放在j列，会不会和之前(0..i-1)的皇后，不共行共列或者共斜线，
            // 如果是，认为有效
            // 如果不是，认为无效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    // record[0..i-1]你需要看，record[i...]不需要看
    // 返回i行皇后，放在了j列，是否有效
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { // 之前的某个k行的皇后
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
