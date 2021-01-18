package org.moi.algorithm.leecode.sort;

import java.util.Arrays;

/**
 * @program:
 * @description: 4. 寻找两个正序数组的中位数 难度： hard
 * @author: moi
 * @create: 2021/1/18 21:16
 **/
public class FindMedianSortedArrays {

    /**
     * 题目：给定两个大小为 m 和 n 的正序（从小到大）数组?nums1 和?nums2。请你找出并返回这两个正序数组的中位数。
     *
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     *
     */

    /**
     * 解法一：先归并数组，再排序
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int[] tmp = new int[len];
        int l1 = 0,l2 = 0;
        int l3 = 0;
        while(true){
            if(l1 == nums1.length){
                System.arraycopy(nums2,l2,tmp,l3,nums2.length-l2);
                break;
            }
            if(l2 == nums2.length){
                System.arraycopy(nums1,l1,tmp,l3,nums1.length-l1);
                break;
            }
            if(nums1[l1]<=nums2[l2]){
                tmp[l3] = nums1[l1];
                l1++;
            }else{
                tmp[l3] = nums2[l2];
                l2++;
            }
            l3++;
        }
        if(len%2==0){
            int mid1 = len/2-1,mid2 = len/2;
            return (tmp[mid1]+tmp[mid2])/2.0;
        }else{
            int mid = len /2;
            return tmp[mid];
        }
    }


    /**
     * 直接找中间点
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        if(len%2==0){
            int mid1 = len/2-1,mid2 = len/2;
            double res = (getKthElement(nums1,nums2,mid1+1)+getKthElement(nums1,nums2,mid2+1))/2.0;
            return res;
        }else{
            int mid = len /2;
            return getKthElement(nums1,nums2,mid+1);
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        new FindMedianSortedArrays().findMedianSortedArrays1(nums1,nums2);
    }

}
