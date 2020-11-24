package org.moi.algorithm.leecode.sort;

import java.util.PriorityQueue;

/**
 * @program:
 * @description: leecode 215题 数组中的第K个最大元素 难度：中等
 * @author: moi
 * @create: 2020/11/24 20:33
 **/
public class KthLargestElementInAnArray {

    /**
     * 题目：在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
     */


    /**
     * 解法一：堆排序
     * @param arr
     * @param k
     * @return
     */
    public static int heapSort(int[] arr,int k){
        //PriorityQueue 结构是java语言中实现的堆，默认排序为小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int len = arr.length;
        for(int i = 0;i<len;i++){
            priorityQueue.offer(arr[i]);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }


    /**
     * 解法二：用快速排序来解决
     * @param nums
     * @param k
     * @return
     */
    public static int quickSort(int[] nums ,int k){
        int left = 0;
        int right = nums.length-1;
        k = nums.length-k;
        while(left <= right){
            int p = partition(nums,left,right);
            if(p < k){
                left = p+1;
            }else if(p>k){
                right = p-1;
            }else{
                return nums[p];
            }
        }
        return -1;
    }

    /**
     * 快速排序的过程
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr,int left,int right){
        if(left == right){
            return left;
        }
        int point = arr[left];
        int i = left,j = right+1;
        while(true){
            //如果符合<区的条件则一直循环，知道大于point这个边界或者走到了数组的尽头才停下来
            while(arr[++i]<point){
                if(i==right){
                    break;
                }
            }
            //如果符合>区的条件则一直循环，知道小于point这个边界或者走到了数组的起点才停下来
            while(arr[--j]>point){
                if(j==left){
                    break;
                }
            }
            //如果两个边界走到了一起，就代表走到了point的那个点应该在的位置，这个时候要跳出循环去做交换，把point这个基准点放到他在数组中排序后应该在的位置上
            if(i >= j){
                break;
            }
            //这次交换是为了保证>区和<区的结构
            swap(arr,i,j);
        }
        swap(arr,j,left);
        return j;
    }

    public static void swap(int[] arr,int i,int j){
        //要慎用异或去进行数字的交换，如果两个数字本来就一样就会导致最后交换出现0，出现脏数据
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(quickSort(arr,4));
    }
}
