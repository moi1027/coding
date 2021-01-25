package org.moi.algorithm.leecode.backtracking;

/**
 * @program:
 * @description: 494. Ŀ��� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/24 21:59
 **/
public class FindTargetSumWays {

    /**
     * ��Ŀ������һ���Ǹ��������飬a1, a2, ..., an, ��һ��Ŀ������S������������������?+?��?-�����������е�����һ���������㶼���Դ�?+?��?-��ѡ��һ�����������ǰ�档
     *
     * ���ؿ���ʹ���������ΪĿ���� S ��������ӷ��ŵķ�������
     *
     * ?
     *
     * ʾ����
     *
     * ���룺nums: [1, 1, 1, 1, 1], S: 3
     * �����5
     * ���ͣ�
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * һ����5�ַ���������Ŀ���Ϊ3��
     *
     *
     */

    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        process(nums,0,0,S);
        return count;
    }

    public void process(int[] nums,int start,int sum,int S){
        if(start == nums.length){
            if(sum == S){
                count++;
                return;
            }
        }else{
            process(nums,start+1,sum+nums[start],S);
            process(nums,start+1,sum-nums[start],S);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0};
        System.out.println(new FindTargetSumWays().findTargetSumWays(arr,1));
    }
}
