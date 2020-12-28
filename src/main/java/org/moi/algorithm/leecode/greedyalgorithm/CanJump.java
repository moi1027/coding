package org.moi.algorithm.leecode.greedyalgorithm;

/**
 * @program:
 * @description: 55. ��Ծ��Ϸ �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/28 22:13
 **/
public class CanJump {

    /**
     * ��Ŀ������һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
     *
     * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
     *
     * �ж����Ƿ��ܹ��������һ��λ�á�
     */

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] jump = {2,5,0,0};
        System.out.println(canJump(jump));


    }
}
