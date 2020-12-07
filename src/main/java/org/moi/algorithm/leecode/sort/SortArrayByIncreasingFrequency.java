package org.moi.algorithm.leecode.sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program:
 * @description: leeCode 第 1636 题 按照频率将数组升序排序 难度 ： easy
 * @author: moi
 * @create: 2020/12/7 21:29
 **/
public class SortArrayByIncreasingFrequency {

    /**
     * 题目:给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
     *
     * 请你返回排序后的数组。
     *
     *
     * 思路：用比较器解释
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
