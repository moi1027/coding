package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: 插入排序
 * @author: moi
 * @create: 2021/2/26 22:26
 **/
public class InsertSort {

    public void insertSort(int[] arr){
        if(arr.length<2||arr==null){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            //先将前面排成有序的，再将后面的项与之前有序的项进行排序
            for (int j = i-1; j >=0&&arr[j]>arr[index] ; j--) {
                swap(arr,index,j);
                index = j;
            }
        }

    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,5,9,2,4};
        new InsertSort().insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
