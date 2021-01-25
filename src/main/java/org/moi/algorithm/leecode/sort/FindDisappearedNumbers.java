package org.moi.algorithm.leecode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description: 448. 找到所有数组中消失的数字 难度：easy
 * @author: moi
 * @create: 2021/1/25 10:43
 **/
public class FindDisappearedNumbers {

    /**
     * 题目：给定一个范围在? 1 ≤ a[i] ≤ n (?n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     *
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 示例:
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [5,6]
     *
     *
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        int j = 0;
        for (int i = 1; i <=len; i++) {
            if(j<len&&nums[j] == i){
                if(j+1<len&&nums[j+1] == i){
                    j+=2;
                }else{
                    j++;
                }
            }else{
               list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        new FindDisappearedNumbers().findDisappearedNumbers(arr);
    }
}
