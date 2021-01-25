package org.moi.algorithm.leecode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description: 448. �ҵ�������������ʧ������ �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/25 10:43
 **/
public class FindDisappearedNumbers {

    /**
     * ��Ŀ������һ����Χ��? 1 �� a[i] �� n (?n = �����С ) �� �������飬�����е�Ԫ��һЩ���������Σ���һЩֻ����һ�Ρ�
     *
     * �ҵ������� [1, n] ��Χ֮��û�г����������е����֡�
     *
     * �����ڲ�ʹ�ö���ռ���ʱ�临�Ӷ�ΪO(n)�������������������? ����Լٶ����ص����鲻���ڶ���ռ��ڡ�
     *
     * ʾ��:
     *
     * ����:
     * [4,3,2,7,8,2,3,1]
     *
     * ���:
     * [5,6]
     *
     *
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        int j = 0;
        for (int i = 1; i <=len; i++) {
            if(j<len&&nums[j] == i){
                if(j+1<len&&nums[j+1] == i){
                    j+=2;
                }else{
                    j++;
                }
            }else{
               list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        new FindDisappearedNumbers().findDisappearedNumbers(arr);
    }
}
