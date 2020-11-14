package org.moi.algorithm.simple;

/**
 * @program:
 * @description: 二分查找
 * @author: moi
 * @create: 2020/11/14 21:33
 **/
public class Dichotomy {

    /**
     * 计算时间复杂度
     * 如果是最差的情况则要找n/2,n/4,n/8....;
     * 得到n = 2^?;
     * 最后时间复杂度为O(log2n);
     */

    /**
     * 二分法查找
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid-1;
            }else if(arr[mid] < target){
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(search(arr,3));
    }
}
