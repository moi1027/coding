package org.moi.algorithm.leecode.greedyalgorithm;

/**
 * @program:
 * @description: 221. ��������� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/21 14:27
 **/
public class MaximalSquare {

    /**
     * ��Ŀ����һ���� '0' �� '1' ��ɵĶ�ά�����ڣ��ҵ�ֻ���� '1' ����������Σ��������������
     */

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;


    }



    public static void main(String[] args) {
//        char[][] matrix = {
//         {'1','0','1','0','0'}
//        ,{'1','0','1','1','1'}
//        ,{'1','1','1','1','1'}
//        ,{'1','0','0','1','0'}
//        };
        char[][] matrix = {
                 {'0','0','1','0'}
                ,{'1','1','1','1'}
                ,{'1','1','1','0'}
                ,{'1','1','1','0'}
                ,{'1','1','0','0'}
                ,{'1','0','1','0'}
        };
        //char[][] matrix = {{'0','1'},{'1','0'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
