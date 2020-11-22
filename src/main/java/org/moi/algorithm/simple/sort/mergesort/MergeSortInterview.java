package org.moi.algorithm.simple.sort.mergesort;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 归并排序的面试题
 * @author: moi
 * @create: 2020/11/22 15:19
 **/
public class MergeSortInterview {

    /**
     * 题目：在一个小组中，一个数的左边比它小的数的总和，叫数的小和，所有数的小和累加起来叫做数组小和。求数组的小和
     *
     * 举例：[1,3,4,2,5]
     * 比1小：无
     * 比3小：1
     * 比4小：1,3
     * 比2小：1
     * 比5小：1,3,4,2
     * 相加和为16
     */

    public static int  process(int[] arr,int L,int R){
        if(L == R){
            return 0;
        }
        //让变量medium 来作为一个L R 下标的中间下标
        int medium = L+((R-L)>>1);
        return process(arr,L,medium)+
        process(arr,medium+1,R)+
        merge(arr,L,medium,R);
    }

    /**
     * 进行合并
     * @param arr
     * @param L
     * @param medium
     * @param R
     */
    public static int merge(int[] arr,int L,int medium,int R){
        //先开辟一个额外的空间
        int[] newInt = new int[R-L+1];
        int i = 0;
        //需要两个指针变量 让这两个指针变量都指向左右两个数组空间的第一个数的下标，通过移动这两个下标从而来进行排序合并
        int p1 = L,p2 = medium+1;
        int res = 0;
        //条件是下标不会越界
        while(p1 <= medium &&p2 <= R){
            //一行代码进行合并
            //解释：当左边的arr[p1]<arr[p2]的时候就将arr[p1]赋值给newInt[i],然后将p1指针指向下一项，反之也是如此
            res += arr[p1]<arr[p2]?(R-p2+1)*arr[p1]:0;
            newInt[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];

        }
        //解释：当有一方的数组已经全部被排序完毕之后，另外一方还有数没有插入到这个额外空间中时，就要将另外一方的数插入到额外空间中
        while(p1 <= medium){
            newInt[i++] = arr[p1++];
        }
        while(p2 <= R){
            newInt[i++] = arr[p2++];
        }
        //将额外空间中排序好的数写回到原数组中
        for(i = 0;i<newInt.length;i++){
            arr[L+i] = newInt[i];
        }
        return res;
        //至此就完成了一个排序
    }







    /**
     * 题目：求降序对
     */
    public static void process2(int[] arr,int L,int R){
        if(L == R){
            return ;
        }
        //让变量medium 来作为一个L R 下标的中间下标
        int medium = L+((R-L)>>1);
         process2(arr,L,medium);
         process2(arr,medium+1,R);
         merge2(arr,L,medium,R);
    }

    static List<int[]> list = new ArrayList<int[]>();

    /**
     * 进行合并
     * @param arr
     * @param L
     * @param medium
     * @param R
     */
    public static void merge2(int[] arr,int L,int medium,int R){
        //先开辟一个额外的空间
        int[] newInt = new int[R-L+1];
        int i = 0;
        //需要两个指针变量 让这两个指针变量都指向左右两个数组空间的第一个数的下标，通过移动这两个下标从而来进行排序合并
        int p1 = L,p2 = medium+1;
        //条件是下标不会越界
        while(p1 <= medium &&p2 <= R){
            //一行代码进行合并
            //解释：当左边的arr[p1]<arr[p2]的时候就将arr[p1]赋值给newInt[i],然后将p1指针指向下一项，反之也是如此
            if(arr[p1]>arr[p2]) {
                list.add(new int[]{arr[p1],arr[p2]});
            }
            newInt[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];

        }
        //解释：当有一方的数组已经全部被排序完毕之后，另外一方还有数没有插入到这个额外空间中时，就要将另外一方的数插入到额外空间中
        while(p1 <= medium){
            newInt[i++] = arr[p1++];
        }
        while(p2 <= R){
            newInt[i++] = arr[p2++];
        }
        //将额外空间中排序好的数写回到原数组中
        for(i = 0;i<newInt.length;i++){
            arr[L+i] = newInt[i];
        }

        //至此就完成了一个排序
    }


    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        process2(arr,0,arr.length-1);
        for(int[] a:list){
            System.out.println(a.toString());
        }
    }
}
