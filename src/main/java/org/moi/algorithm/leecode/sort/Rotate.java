package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 48. 旋转图像 难度：medium
 * @author: moi
 * @create: 2021/1/10 21:58
 **/
public class Rotate {

    /**
     * 题目：给定一个 n?×?n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 思路：找规律
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
