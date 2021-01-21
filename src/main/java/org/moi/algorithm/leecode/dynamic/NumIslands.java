package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description: 200. 岛屿数量 难度：medium
 * @author: moi
 * @create: 2021/1/20 22:13
 **/
public class NumIslands {

    /**
     * 题目：给你一个由?'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 输出：1
     *
     *
     */

    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int nLandNums = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(grid[i][j] == '1'){
                    infect(grid,i,j);
                    nLandNums++;
                }
            }
        }
        return nLandNums;
    }


    /**
     * 感染函数
     * @param nums
     * @param i
     * @param j
     */
    public void infect(char[][] nums,int i,int j){
        if(i<0||j<0||i>=nums.length||j>=nums[0].length||nums[i][j]!='1'){
            return;
        }
        nums[i][j] = '2';
        infect(nums,i-1,j);
        infect(nums,i+1,j);
        infect(nums,i,j-1);
        infect(nums,i,j+1);
    }

    public static void main(String[] args) {
        char[][] nums = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char[][] nums = {{'1','0','1','1','0','1','1'}};
        System.out.println(new NumIslands().numIslands(nums));
    }
}
