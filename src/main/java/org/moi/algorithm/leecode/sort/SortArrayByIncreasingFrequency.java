package org.moi.algorithm.leecode.sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program:
 * @description: leeCode �� 1636 �� ����Ƶ�ʽ������������� �Ѷ� �� easy
 * @author: moi
 * @create: 2020/12/7 21:29
 **/
public class SortArrayByIncreasingFrequency {

    /**
     * ��Ŀ:����һ���������� nums �����㽫���鰴��ÿ��ֵ��Ƶ�� ���� ��������ж��ֵ��Ƶ����ͬ�����㰴����ֵ�������� ���� ����
     *
     * ���㷵�����������顣
     *
     *
     * ˼·���ñȽ�������
     */

    public static int[] frequencySort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            list.add(nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(!map.get(o1).equals(map.get(o2))){
                    return map.get(o1)-map.get(o2);
                }else{
                    return o2-o1;
                }
            }
        });
        for(int i= 0;i<nums.length;i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1,-6,4,5,-6,1,4,1};
        frequencySort(arr);
    }
}
