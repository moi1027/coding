package org.moi.algorithm.leecode.sort;

import static org.moi.algorithm.simple.sort.quicksort.QuickSortDemo.swap;

/**
 * @program:
 * @description: ������17 ��СK����
 * @author: moi
 * @create: 2020/12/9 22:14
 **/
public class MinKNumber {

    /**
     * ��Ŀ�����һ���㷨���ҳ���������С��k������������˳�򷵻���k�������ɡ�
     */
    public static int[] smallestK(int[] arr, int k) {
        if(arr.length < 2 || arr == null){
            return null;
        }
        int len = arr.length;
        int heapSize = len;
        //���¶��� �γɴ����
        for(int i = len -1 ;i>=0;i--){
            heaipy(arr,i,arr.length);
        }
        //����ʼ�����ѵĸ��ڵ�Ҳ�������ֵ�ŵ���������һλ���ܶ���ʼ������
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
     * ���϶���ȥ�����γɴ����
     * @param arr
     * @param index
     * @param heapSize ����ѵĳ���
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
