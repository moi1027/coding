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

    /**
     * ��̬�滮
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums,0,maxF,0,len);
        System.arraycopy(nums,0,minF,0,len);
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(nums[i],nums[i]*minF[i-1]));
            minF[i] = Math.min(minF[i-1]*nums[i],Math.min(nums[i],nums[i]*maxF[i-1]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,maxF[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(new MaxProduct().maxProduct(nums));
    }

}
