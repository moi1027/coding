package org.moi.algorithm.simple;

/**
 * @program:
 * @description: 插入排序
 * @author: moi
 * @create: 2020/11/14 20:46
 **/
public class InsertionSort {

    /**
     *
     * 计算插入排序的时间复杂度
     * 计算时间复杂度要按最差的情况来计算
     * 拿{5,4,3,2,1}数组来计算时间复杂度
     * 第一次先比较一次再交换一次 为1+1 得到{4,5,3,2,1}
     * 第二次先比较两次再交换两次次 为2+2 得到{3,4,5,2,1}
     * ....
     * 从而得到时间复杂度为2+4+...+n =n^2+n
     * 去除常数项和低次项得到时间复杂度为O(n^2)
     */

    public static int[] sort(int[] arr){
        int len = arr.length;
        int tmp; //中间变量
        int j;
        for (int i = 1;i < len;i++){
            tmp = arr[i];
            //往回遍历那个已经排序好的数组
            for (j = i - 1;j >= 0 && arr[j] > tmp;j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(sort(arr).toString());
    }


}
