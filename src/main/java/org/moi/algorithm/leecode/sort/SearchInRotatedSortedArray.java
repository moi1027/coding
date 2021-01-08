package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: 33. ������ת�������� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/8 22:45
 **/
public class SearchInRotatedSortedArray {

    /**
     * ��Ŀ���������е��������� nums ��Ԥ��δ֪��ĳ�����Ͻ�������ת�����磬 [0,1,2,4,5,6,7] ����ת����ܱ�Ϊ?[4,5,6,7,0,1,2] ����
     *
     * ����������������?target ����������д������Ŀ��ֵ���򷵻��������������򷵻�?-1?��
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺nums = [4,5,6,7,0,1,2], target = 0
     * �����4
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
