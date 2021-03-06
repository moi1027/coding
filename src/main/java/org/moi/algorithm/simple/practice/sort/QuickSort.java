package org.moi.algorithm.simple.practice.sort;

/**
 * @program:
 * @description: 快速排序
 * @author: moi
 * @create: 2021/3/6 14:21
 **/
public class QuickSort {

    /**
     * 第一种：快速排序第一弹，以数组的最后一个数为基准，找到他的最终位置，左边是小于等于区，右边是大于区域，循环往复，就可以将一个无序的数组排序成有序的
     */

    public void swap(int[] arr,int l,int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public int partition(int[] arr,int left,int right){
        if(left>right){
            return -1;
        }
        if(left==right){
            return left;
        }
        int lessEqual = left-1;
        int index = left;
        while(index<right){
            if(arr[index]<=arr[right]){
                swap(arr,index,++lessEqual);
            }
            index++;
        }
        swap(arr,right,++lessEqual);
        return lessEqual;
    }

    public void process1(int[] arr,int l,int r){
        if(l>r){
            return;
        }
        int middle = partition(arr,l,r);
        process1(arr,l,middle-1);
        process1(arr,middle+1,r);
    }


    public void quickSort1(int[] arr){
        if(arr.length<2){
            return;
        }
        process1(arr,0,arr.length-1);
    }


    /**
     * 第二种：一个无序的数组arr,取数组的最后一位作为标志，在数组中找到三个区间，左边是<标志的，中间是等于标志的，右边是>区，也就是常见的荷兰国旗问题
     */

    public  int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1; // < 区 右边界
        int more = R;     // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    public void process2(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int[] mid = netherlandsFlag(arr,l,r);
        process2(arr,l,mid[0]-1);
        process2(arr,mid[1]+1,r);
    }

    public void quickSort2(int[] arr){
        if(arr.length<2){
            return;
        }
        process2(arr,0,arr.length-1);
    }


    public static void main(String[] args) {
        int[] arr = {1,3,6,2,8,3,5};
        new QuickSort().quickSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
