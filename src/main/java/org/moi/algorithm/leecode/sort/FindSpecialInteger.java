package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 1287. 有序数组中出现次数超过25%的元素 难度：easy;
 * @author: moi
 * @create: 2021/1/10 20:07
 **/
public class FindSpecialInteger {

    /**
     * 题目：给你一个非递减的?有序?整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
     *
     * 请你找到并返回这个整数
     *
     * ?
     *
     * 示例：
     *
     * 输入：arr = [1,2,2,6,6,6,6,7,10]
     * 输出：6
     *
     *
     */

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int flag = len >>2;
        int max = 1;
        int n = 1;
        for(int i = 1;i<len ;i++){
            if(arr[i]== arr[i-1]){
                n++;
            }else{
                max = Math.max(max,n);
                if(max>flag){
                    return arr[i-1];
                }
                n = 1;
            }
        }
        return arr[len-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        new FindSpecialInteger().findSpecialInteger(arr);
    }
}
