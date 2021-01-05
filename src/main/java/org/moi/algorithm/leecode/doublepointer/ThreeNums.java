package org.moi.algorithm.leecode.doublepointer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description: 15. ����֮�� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/5 21:06
 **/
public class ThreeNums {
    /**
     * ��Ŀ������һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��ʹ��?a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣
     *
     * ע�⣺���в����԰����ظ�����Ԫ�顣
     *
     * ?
     *
     * ʾ����
     *
     * �������� nums = [-1, 0, 1, 2, -1, -4]��
     *
     * ����Ҫ�����Ԫ�鼯��Ϊ��
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     *
     */



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3){
            return null;
        }
        //������
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0){
                return res;
            }
            if(i>0&&nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            //˫ָ��
            while(left<right){
                if(nums[left]+nums[right]==target){
                    res.add(Arrays.asList(-target,nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right+1]){
                        right--;
                    }
                }else if(nums[left]+nums[right]>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new ThreeNums().threeSum(nums);
    }

}
