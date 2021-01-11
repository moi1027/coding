package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description: 64. ��С·���� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/11 11:28
 **/
public class MinPathSum {

    /**
     * ��Ŀ������һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
     *
     * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
     * �����7
     * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С��
     *
     * ˼·���ö�̬�滮��
     */

    public int minPathSum(int[][] grid) {
        int xlen = grid[0].length;
        int ylen = grid.length;
        int[][] dp = new int[ylen][xlen];
        //��ʼ��
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
