package org.moi.algorithm.leecode.sort;

import static org.moi.algorithm.simple.sort.quicksort.QuickSortDemo.swap;

/**
 * @program:
 * @description: 面试题17 最小K个数
 * @author: moi
 * @create: 2020/12/9 22:14
 **/
public class MinKNumber {

    /**
     * 题目：设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     */
    public static int[] smallestK(int[] arr, int k) {
        if(arr.length < 2 || arr == null){
            return null;
        }
        int len = arr.length;
        int heapSize = len;
        //从下而上 形成大根堆
        for(int i = len -1 ;i>=0;i--){
            heaipy(arr,i,arr.length);
        }
        //排序开始，将堆的根节点也就是最大值放到数组的最后一位，周而复始的排序
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heaipy(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
        int[] arr1 = new int[k];
        for(int i = 0;i<k;i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }

    /**
     * 自上而下去交换形成大根堆
     * @param arr
     * @param index
     * @param heapSize 大根堆的长度
     */
    public static void heaipy(int[] arr,int index,int heapSize){
        int left = 2*index+1;
        while(left < heapSize){
            int  lagest = left+1 < heapSize && arr[left]<arr[left+1] ?left+1:left;
            lagest = arr[index] < arr[lagest]?lagest:index;
            if(lagest == index){
                break;
            }
            swap(arr,index,lagest);
            index = lagest;
            left = 2*index+1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        smallestK(arr,4);
    }

}
