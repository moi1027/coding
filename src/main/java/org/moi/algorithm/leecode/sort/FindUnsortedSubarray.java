package org.moi.algorithm.leecode.sort;

import java.util.Arrays;

/**
 * @program:
 * @description: 581. 最短无序连续子数组 难度： medium
 * @author: moi
 * @create: 2021/1/24 20:39
 **/
public class FindUnsortedSubarray {

    /**
     * 题目：给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     *
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     *
     *
     */

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] tmp = new int[len];
        System.arraycopy(nums,0,tmp,0,len);
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != tmp[i]){
                break;
            }else{
                count++;
            }
        }
        if(count == len){
            return 0;
        }
        for (int i = len-1; i >=0 ; i--) {
            if(nums[i] != tmp[i]){
                break;
            }else{
                count++;
            }
        }
        return len-count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(arr));
    }
}
