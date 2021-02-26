package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: 找到一个数组中的奇数项次的数（默认只有一个奇数项次的数）
 * @author: moi
 * @create: 2021/2/26 22:51
 **/
public class FindArrOddNum {

    /**
     * 思路：用异或运算,两个相同的数进行异或运算会等于1
     */

    public int findOddNum(int[] arr){
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num = arr[i]^num;
        }
        System.out.println(num);
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,2,2};
        new FindArrOddNum().findOddNum(arr);
    }
}
