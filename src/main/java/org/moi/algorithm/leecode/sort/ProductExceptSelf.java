package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 238. ��������������ĳ˻� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/22 22:39
 **/
public class ProductExceptSelf {

    /**
     * ��Ŀ������һ������Ϊ?n?����������?nums������?n > 1�������������?output?������ output[i]?����?nums?�г�?nums[i]?֮�������Ԫ�صĳ˻���
     *
     * ?
     *
     * ʾ��:
     *
     * ����: [1,2,3,4]
     * ���: [24,12,8,6]
     *
     *
     */

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1]*nums[i];
        }
        for (int i = len-2; i >=0 ; i--) {
            right[i] = right[i+1]*right[i];
        }
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,0};
        new ProductExceptSelf().productExceptSelf(nums);
    }
}
