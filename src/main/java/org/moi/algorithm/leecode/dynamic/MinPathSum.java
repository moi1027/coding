package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description: 64. 最小路径和 难度：medium
 * @author: moi
 * @create: 2021/1/11 11:28
 **/
public class MinPathSum {

    /**
     * 题目：给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     *
     * 思路：用动态规划做
     */

    public int minPathSum(int[][] grid) {
        int xlen = grid[0].length;
        int ylen = grid.length;
        int[][] dp = new int[ylen][xlen];
        //初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i <xlen ; i++) {
            dp[0][i] =grid[0][i]+dp[0][i-1];
        }
        for (int i = 1; i < ylen; i++) {
            dp[i][0] =grid[i][0]+ dp[i-1][0];
        }
        for (int i = 1; i < ylen; i++) {
            for (int j = 1; j < xlen; j++) {
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[ylen-1][xlen-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        new MinPathSum().minPathSum(arr);


    }


}
