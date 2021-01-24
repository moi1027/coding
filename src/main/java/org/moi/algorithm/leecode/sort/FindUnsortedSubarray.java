package org.moi.algorithm.leecode.sort;

import java.util.Arrays;

/**
 * @program:
 * @description: 581. ����������������� �Ѷȣ� medium
 * @author: moi
 * @create: 2021/1/24 20:39
 **/
public class FindUnsortedSubarray {

    /**
     * ��Ŀ������һ���������� nums ������Ҫ�ҳ�һ�� ���������� �����������������������������ô�������鶼���Ϊ��������
     *
     * �����ҳ���������� ��� �����飬��������ĳ��ȡ�
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺nums = [2,6,4,8,10,9,15]
     * �����5
     * ���ͣ���ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
     *
     *
     */

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] tmp = new int[len];
        System.arraycopy(nums,0,tmp,0,len);
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != tmp[i]){
                break;
            }else{
                count++;
            }
        }
        if(count == len){
            return 0;
        }
        for (int i = len-1; i >=0 ; i--) {
            if(nums[i] != tmp[i]){
                break;
            }else{
                count++;
            }
        }
        return len-count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(arr));
    }
}
