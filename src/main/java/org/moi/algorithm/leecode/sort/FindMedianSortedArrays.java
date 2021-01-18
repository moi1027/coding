package org.moi.algorithm.leecode.sort;

import java.util.Arrays;

/**
 * @program:
 * @description: 4. Ѱ�����������������λ�� �Ѷȣ� hard
 * @author: moi
 * @create: 2021/1/18 21:16
 **/
public class FindMedianSortedArrays {

    /**
     * ��Ŀ������������СΪ m �� n �����򣨴�С��������?nums1 ��?nums2�������ҳ������������������������λ����
     *
     * ���ף��������һ��ʱ�临�Ӷ�Ϊ O(log (m+n)) ���㷨�����������
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺nums1 = [1,3], nums2 = [2]
     * �����2.00000
     * ���ͣ��ϲ����� = [1,2,3] ����λ�� 2
     *
     *
     */

    /**
     * �ⷨһ���ȹ鲢���飬������
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
     * ֱ�����м��
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
        /* ��Ҫ˼·��Ҫ�ҵ��� k (k>1) С��Ԫ�أ���ô��ȡ pivot1 = nums1[k/2-1] �� pivot2 = nums2[k/2-1] ���бȽ�
         * ����� "/" ��ʾ����
         * nums1 ��С�ڵ��� pivot1 ��Ԫ���� nums1[0 .. k/2-2] ���� k/2-1 ��
         * nums2 ��С�ڵ��� pivot2 ��Ԫ���� nums2[0 .. k/2-2] ���� k/2-1 ��
         * ȡ pivot = min(pivot1, pivot2)������������С�ڵ��� pivot ��Ԫ�ع��Ʋ��ᳬ�� (k/2-1) + (k/2-1) <= k-2 ��
         * ���� pivot �������Ҳֻ���ǵ� k-1 С��Ԫ��
         * ��� pivot = pivot1����ô nums1[0 .. k/2-1] ���������ǵ� k С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums1 ����
         * ��� pivot = pivot2����ô nums2[0 .. k/2-1] ���������ǵ� k С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums2 ����
         * �������� "ɾ��" ��һЩԪ�أ���ЩԪ�ض��ȵ� k С��Ԫ��ҪС���������Ҫ�޸� k ��ֵ����ȥɾ�������ĸ���
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // �߽����
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // �������
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
