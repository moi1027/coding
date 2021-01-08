package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置 难度：medium
 * @author: moi
 * @create: 2021/1/8 23:09
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 题目：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回?[-1, -1]。
     *
     * 进阶：
     *
     * 你可以设计并实现时间复杂度为?O(log n)?的算法解决此问题吗？
     * ?
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     *
     * 思路：二分查找的思想，要注意细节
     */

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        if(nums.length == 1 && nums[0] == target){
            return new int[]{0,0};
        }
        int len = nums.length-1;

        int left = 0;
        int right = len;
        int mid = (left+right)>>1;
        while(left<=right){
            if(nums[mid]>target){
                right = mid-1;
                mid = (left+right)>>1;
            }else if(nums[mid]<target){
                left = mid+1;
                mid = (left+right)>>1;
            }else{
                int start,end;
                start = end = mid;
                if(mid==0){
                    while(end<len){
                        if(end<len&&nums[end+1] == nums[mid]){
                            end++;
                        }else{
                            break;
                        }
                    }
                }else if(mid == len){
                    while(start>=0){
                        if(start>0&&nums[start-1] == nums[mid]){
                            start--;
                        }else{
                            break;
                        }
                    }
                }else{
                    while(start>=0){
                        if(start>0&&nums[start-1] == nums[mid]){
                            start--;
                        }else{
                            break;
                        }
                    }
                    while(end<len){
                        if(end<len&&nums[end+1] == nums[mid]){
                            end++;
                        }else{
                            break;
                        }
                    }
                }
                return new int[]{start,end};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        new FindFirstAndLastPositionOfElementInSortedArray().searchRange(arr,1);
    }
}
