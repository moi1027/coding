package org.moi.algorithm.simple.sort.heapsort;

import static org.moi.algorithm.simple.sort.quicksort.QuickSortDemo.swap;

/**
 * @program:
 * @description: 排序之一: 堆排序 时间复杂度：O(N*logN)
 * @author: moi
 * @create: 2020/11/23 16:58
 **/
public class HeapSortDemo {


    /**
     *
     * 堆的定义：只有大根堆和小根堆两种情况叫做堆，大根堆是指根节点是整个完全二叉树的最大的一个节点，小根堆则是相反
     *
     * 堆排序：
     *      概念：
     *          1.先让需要排序的数组转换成大根堆
     *              1）从上往下 heapInsert 时间复杂度：O(N*logN)
     *              2)从下往上 heaipy 时间复杂度：O(N)
     *          2.把堆的最大值个堆的末尾值交换，减小堆的大小之后，再调整剩下的二叉树为堆，周而复始
     *          3.当堆的大小减小为0的时候，排序结束
     *
     *
     */


    public static int[] heapSort(int[] arr){
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
        return arr;
    }

    /**
     * 自下而上去交换形成大根堆
     * @param arr
     * @param index
     */
    public void heapInsert(int[] arr,int index){
        //判断自身的值是否大于他的父节点，如果大于则交换
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
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
        int[] arr = {1,2,3,4,7,1,3,1};
        arr = heapSort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }



}
