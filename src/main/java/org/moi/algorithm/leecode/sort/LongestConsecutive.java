package org.moi.algorithm.leecode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: 128. ��������� �Ѷȣ�hard
 * @author: moi
 * @create: 2021/1/15 23:05
 **/
public class LongestConsecutive {

    /**
     * ��Ŀ������һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
     *
     * ?
     *
     * ���ף��������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ?O(n) �Ľ��������
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺nums = [100,4,200,1,3,2]
     * �����4
     * ���ͣ���������������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
     *
     *
     */

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]+1){
                num++;
            }else if(nums[i]==nums[i-1]){

            }else{
                max = Math.max(max,num);
                num = 1;
            }
        }
        max = Math.max(max,num);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(new LongestConsecutive().longestConsecutive(arr));
    }
}
