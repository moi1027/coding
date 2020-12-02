package org.moi.algorithm.leecode.sort;

import java.util.*;

/**
 * @program:
 * @description: leeCode  1471 数组中的 k 个最强值 难度：medium
 * @author: moi
 * @create: 2020/12/2 21:59
 **/
public class TheKStrongestValuesArray {

    /**
     * 给你一个整数数组 arr 和一个整数 k 。
     *
     * 设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
     *
     * ?|arr[i] - m| > |arr[j]?- m|
     * ?|arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
     *
     *
     *
     * 思路：本题的思路可以用比较器，但是有个坑，直接使用Arrays.sort(),在这个方法中使用比较器一定要是继承至Object的泛型！！！，别踩坑
     *
     */

    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length-1)/2];
        List<Integer> list = new ArrayList<>();
        for(int i  = 0;i<arr.length;i++){
            list.add(arr[i]);
        }
        //自定义比较器
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //这个是从大到小排列的
                if(Math.abs(o1-m)>Math.abs(o2-m)){
                    return -1;
                }else if(Math.abs(o1-m)==Math.abs(o2-m)){
                    return o1>o2?-1:1;
                }
                return 1;
            }
        });
        int[] res = new int[k];
        for(int i  = 0;i<k;i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr =  {-7,22,17,3};
        getStrongest(arr,2);
    }

}
