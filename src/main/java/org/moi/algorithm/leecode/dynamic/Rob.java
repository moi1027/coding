package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description: 198. 打家劫舍 难度：medium
 * @author: moi
 * @create: 2021/1/20 21:49
 **/
public class Rob {

    /**
     * 题目：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * ?    偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 思路：用动态规划解
     */

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        System.arraycopy(nums,0,dp,0,len);
        if(len == 1){
            return dp[0];
        }
        if(len == 2){
            return Math.max(dp[0],dp[1]);
        }
        dp[2] = Math.max(dp[2],dp[0]+dp[2]);
        for(int i = 3;i<len;i++){
            dp[i] = Math.max(dp[i-3]+dp[i],dp[i-2]+dp[i]);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(new Rob().rob(nums));
    }
}
