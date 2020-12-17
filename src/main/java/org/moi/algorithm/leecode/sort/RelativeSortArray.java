package org.moi.algorithm.leecode.sort;

import java.util.*;

/**
 * @program:
 * @description: leeCode 1122 数组的相对排序 难度：easy
 * @author: moi
 * @create: 2020/12/17 21:24
 **/
public class RelativeSortArray {

    /**
     * 题目：给你两个数组，arr1 和?arr2，
     *
     * arr2?中的元素各不相同
     * arr2 中的每个元素都出现在?arr1?中
     * 对 arr1?中的元素进行排序，使 arr1 中项的相对顺序和?arr2?中的相对顺序相同。未在?arr2?中出现过的元素需要按照升序放在?arr1?的末尾。
     *
     * 思路：用自定义排序
     */

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr1.length;i++){
            list.add(arr1[i]);
        }
        for(int i = 0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.containsKey(o1)||map.containsKey(o2)){
                    return map.getOrDefault(o1,1001)-map.getOrDefault(o2,1001);
                }
                return o1-o2;
            }
        });
        for(int i = 0;i<list.size();i++){
            arr1[i] = list.get(i);
        }
        return arr1;
    }

}
