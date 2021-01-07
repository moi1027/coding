package org.moi.algorithm.leecode.sort;

import java.util.Arrays;

/**
 * @program:
 * @description: 31. ��һ������ �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/7 22:49
 **/
public class NextPermutation {

    /**
     * ��Ŀ��ʵ�ֻ�ȡ ��һ������ �ĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
     *
     * �����������һ����������У��������������г���С�����У����������У���
     *
     * ���� ԭ�� �޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺nums = [1,2,3]
     * �����[1,3,2]
     * ʾ�� 2��
     *
     * ���룺nums = [3,2,1]
     * �����[1,2,3]
     * ʾ�� 3��
     *
     * ���룺nums = [1,1,5]
     * �����[1,5,1]
     * ʾ�� 4��
     *
     * ���룺nums = [1]
     * �����[1]
     *
     *
     */

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        new NextPermutation().nextPermutation(nums);
    }
}
