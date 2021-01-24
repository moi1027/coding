package org.moi.algorithm.leecode.backtracking;

import java.util.Stack;

/**
 * @program:
 * @description: 560. ��ΪK�������� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/24 20:50
 **/
public class SubarraySum {

    /**
     * ��Ŀ������һ�����������һ������?k������Ҫ�ҵ��������к�Ϊ?k?��������������ĸ�����
     *
     * ʾ�� 1 :
     *
     * ����:nums = [1,1,1], k = 2
     * ���: 2 , [1,1] �� [1,1] Ϊ���ֲ�ͬ�������
     *
     *
     */

    int count = 0;
    public int subarraySum(int[] nums, int k) {
        if(nums == null){
            return count;
        }
        for (int i = 0; i <nums.length ; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp+=nums[j];
                if(tmp == k){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {-92,-63,75,-86,-58,22,31,-16,-66,-67,420};
        System.out.println(new SubarraySum().subarraySum(arr,100));
    }
}
