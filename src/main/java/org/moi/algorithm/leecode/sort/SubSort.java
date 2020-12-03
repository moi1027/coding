package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: leeCode 面试题 部分排序 难度： medium
 * @author: moi
 * @create: 2020/12/3 16:43
 **/
public class SubSort {

    /**
     * 题目：给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
     *
     */


    public static int[] subSort(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = Math.max(max, array[i]);
            }

            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[] {first, last};

    }

    public static void main(String[] args) {
        int[] array = {1,3,9,7,5};
        subSort(array);
    }
}
