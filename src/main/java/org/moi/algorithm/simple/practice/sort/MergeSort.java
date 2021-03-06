package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: 归并排序
 * @author: moi
 * @create: 2021/3/6 15:16
 **/
public class MergeSort {

    /**
     * 将两个有序的数组合并为一个有序的数组为归并排序
     */

    public void mergeSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }

    public void process(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int mid = l+((r-l)>>1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public void merge(int[] arr,int l,int m,int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while(p1<=m&&p2<=r){
            help[i++]=arr[p1]>arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=m){
            help[i++]=arr[p1++];
        }
        while(p2<=r){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4,2,6};
        new MergeSort().mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
