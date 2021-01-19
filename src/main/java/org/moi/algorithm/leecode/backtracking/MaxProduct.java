package org.moi.algorithm.leecode.backtracking;

/**
 * @program:
 * @description: 152. �˻���������� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/19 22:05
 **/
public class MaxProduct {

    /**
     * ��Ŀ������һ���������� nums?�������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
     *
     * ?
     *
     * ʾ�� 1:
     *
     * ����: [2,3,-2,4]
     * ���: 6
     * ����:?������ [2,3] �����˻� 6��
     *
     *
     */

    int max = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            max = Math.max(max,count);
            for (int j = i+1; j < nums.length; j++) {
                count *=nums[j];
                max = Math.max(max,count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

}
