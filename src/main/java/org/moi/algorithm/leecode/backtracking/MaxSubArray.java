package org.moi.algorithm.leecode.backtracking;

/**
 * @program:
 * @description: 53. ��������  �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/11 10:45
 **/
public class MaxSubArray {
    /**
     * ��Ŀ������һ���������� nums?���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
     *
     * ʾ��:
     *
     * ����: [-2,1,-3,4,-1,2,1,-5,4]
     * ���: 6
     * ����:?����������?[4,-1,2,1] �ĺ����Ϊ?6��
     *
     *
     */

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int num = 0;
            for (int j = i; j < len; j++) {
                max = Math.max(num+=nums[j],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1};
        new MaxSubArray().maxSubArray(arr);
    }
}
