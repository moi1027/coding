package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 33. 搜索旋转排序数组 难度：medium
 * @author: moi
 * @create: 2021/1/8 22:45
 **/
public class SearchInRotatedSortedArray {

    /**
     * 题目：升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为?[4,5,6,7,0,1,2] ）。
     *
     * 请你在数组中搜索?target ，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     *
     */

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(target<nums[0]){
            for(int i = nums.length-1;i>=0;i--){
                if(nums[i]==target){
                    return i;
                }
                if(nums[nums.length-1]<nums[i]){
                    return -1;
                }
            }
        }else{
            for(int i = 0;i<nums.length;i++){
                if(nums[i]==target){
                    return i;
                }
                if(nums[0]>nums[i]){
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        new SearchInRotatedSortedArray().search(arr,0);
    }
}
