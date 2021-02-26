package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: �ҵ�һ�������е�������ε�����Ĭ��ֻ��һ��������ε�����
 * @author: moi
 * @create: 2021/2/26 22:51
 **/
public class FindArrOddNum {

    /**
     * ˼·�����������,������ͬ�������������������1
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
