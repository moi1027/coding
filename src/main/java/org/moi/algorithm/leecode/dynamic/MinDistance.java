package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description:  72. 编辑距离 难度：hard
 * @author: moi
 * @create: 2021/1/12 21:03
 **/
public class MinDistance {

    /**
     * 题目：给你两个单词?word1 和?word2，请你计算出将?word1?转换成?word2 所使用的最少操作数?。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * ?
     *
     * 示例?1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     *
     *
     */

    public int minDistance(String word1, String word2) {
        int xLen = word1.length();
        int yLen = word2.length();
        int[][] dp = new int[xLen+1][yLen+1];
        for (int i = 0; i <= xLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= yLen; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(word2.charAt(i-1) == word1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }
        return dp[xLen][yLen];
    }
}
