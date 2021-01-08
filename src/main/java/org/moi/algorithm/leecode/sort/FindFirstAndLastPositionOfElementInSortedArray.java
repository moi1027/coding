package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 34. �����������в���Ԫ�صĵ�һ�������һ��λ�� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/8 23:09
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * ��Ŀ������һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
     *
     * ��������в�����Ŀ��ֵ target������?[-1, -1]��
     *
     * ���ף�
     *
     * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ?O(log n)?���㷨�����������
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺nums = [5,7,7,8,8,10], target = 8
     * �����[3,4]
     *
     *
     * ˼·�����ֲ��ҵ�˼�룬Ҫע��ϸ��
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
