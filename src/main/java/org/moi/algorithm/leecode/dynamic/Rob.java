package org.moi.algorithm.leecode.dynamic;

/**
 * @program:
 * @description: 198. ��ҽ��� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/20 21:49
 **/
public class Rob {

    /**
     * ��Ŀ������һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
     *
     * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺[1,2,3,1]
     * �����4
     * ���ͣ�͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
     * ?    ͵�Ե�����߽�� = 1 + 3 = 4 ��
     *
     * ˼·���ö�̬�滮��
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
