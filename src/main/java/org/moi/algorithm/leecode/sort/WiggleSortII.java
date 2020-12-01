package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program:
 * @description: leeCode 摆动排序 难度： medium
 * @author: moi
 * @create: 2020/12/1 22:11
 **/
public class WiggleSortII {


    /**
     * 题目：给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
     *
     * 思路：将数组拍好序，然后将后半部分插入到前半部分中
     */

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] n = new int[nums.length];
        int len = 0;
        if(nums.length%2==0){
            len = nums.length/2;
        }else{
            len = nums.length/2+1;
        }
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if(i%2!=0){
                n[i] =nums[j+len];
                j++;
            }else{
                n[i] = nums[j];
            }
        }
        for(int i = 0;i<n.length;i++){
            nums[i] = n[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,1,1,6,4};
        wiggleSort(arr);
    }
}
