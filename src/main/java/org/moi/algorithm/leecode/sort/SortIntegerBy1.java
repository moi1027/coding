package org.moi.algorithm.leecode.sort;

import java.util.*;

/**
 * @program:
 * @description: leeCode 1356  根据数字二进制下 1 的数目排序 难度： easy
 * @author: moi
 * @create: 2020/12/4 22:59
 **/
public class SortIntegerBy1 {

    /**
     * 题目：给你一个整数数组?arr?。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
     *
     * 如果存在多个数字二进制中?1?的数目相同，则必须将它们按照数值大小升序排列。
     *
     * 请你返回排序后的数组。
     *
     * 思路：计算每个十进制数转二进制数后里面 1 的个数
     */

    public static int[] sortByBits(int[] arr) {
        //题目要求最大个数不超过500
        int[] count = new int[500];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            list.add(arr[i]);
            count[i] = countBy1(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(count[o1]!=count[o2]){
                    return count[o1]>count[o2]?1:-1;
                }else{
                    return o1>o2?1:-1;
                }
            }
        });
        for(int i = 0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        return  arr;
    }

    //计算1的个数
    public static int countBy1(int num){
        int res = 0;
        while(num!= 0){
            res += num % 2;
            num =num/2;
        }
        return res;
    }
}
