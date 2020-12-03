package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program:
 * @description: leeCode 面试题 交换和 难度：medium
 * @author: moi
 * @create: 2020/12/3 15:58
 **/
public class SumSwap {

    /**
     *题目： 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
     *
     * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
     *
     *
     * 思路：用双指针解决
     */

    public static int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0 ;i<array1.length;i++){
            sum1+=array1[i];
        }
        for(int i = 0 ;i<array2.length;i++){
            sum2+=array2[i];
        }
        int i = 0;
        int j = 0;
        while(i<array1.length&&j<array2.length){
            if(sum1-array1[i]+array2[j]>sum2+array1[i]-array2[j]){
                i++;
            }else if(sum1-array1[i]+array2[j]<sum2+array1[i]-array2[j]){
                j++;
            }else{
                return new int[]{array1[i],array2[j]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] array1 = {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] array2 = {52, 20, 78, 50, 38, 96, 81, 20};
        findSwapValues(array1,array2);
    }
}
