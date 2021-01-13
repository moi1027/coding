package org.moi.algorithm.leecode.stack;

/**
 * @program:
 * @description: 85. 最大矩形 难度：hard
 * @author: moi
 * @create: 2021/1/13 22:09
 **/
public class MaximalRectangle {

    /**
     * 题目：给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     *
     */

    /**
     * 方法一：优化暴力法
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int xLen = matrix.length;

        if(xLen == 0){
            return 0;
        }
        int yLen = matrix[0].length;
        int[][] tmp = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(matrix[i][j] == '1'){
                    tmp[i][j] = (j==0?0:tmp[i][j-1])+1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                int width = tmp[i][j];
                int area = width;
                for (int k = i-1; k >=0 ; k--) {
                    width = Math.min(width,tmp[k][j]);
                    area = Math.max(area,width*(i-k+1));
                }
                res = Math.max(res,area);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        new MaximalRectangle().maximalRectangle(arr);
    }
}
