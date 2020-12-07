package org.moi.algorithm.leecode.sort;

import java.util.Random;

/**
 * @program:
 * @description: leeCode 第75题  颜色分类 难度：medium
 * @author: moi
 * @create: 2020/12/7 10:48
 **/
public class SortColors {

    /**
     * 题目：给定一个包含红色、白色和蓝色，一共?n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、?1 和 2 分别表示红色、白色和蓝色。
     *
     * 思路：排序 原地算法，首选快速排序
     *
     */

    public static void sortColors(int[] nums) {
        if(nums.length == 0){
            return;
        }
        process(nums,0,nums.length-1);
    }

    public static void process(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        //随机生成一个基准数
        int flag = (int)Math.random() * (r - l + 1);
        //将基准数和传入数组的最后一个数进行交换
        swap(arr,flag,r);
        int[] partition = partition(arr,l,r);
        process(arr,l,partition[0]-1);
        process(arr,partition[1]+1,r);
    }



    public static int[] partition(int[] arr,int l,int r){
        if(l>r){
            return new int[]{-1,-1};
        }
        if(l==r){
            return new int[]{l,r};
        }
        int less = l-1;
        int more = r;
        int index = l;
        while(index<more){
            if(arr[index] == arr[r]){
                index++;
            }else if(arr[index] > arr[r]){
                swap(arr,index,--more);
            }else{
                swap(arr,index++,++less);
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};

    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
    }
}
