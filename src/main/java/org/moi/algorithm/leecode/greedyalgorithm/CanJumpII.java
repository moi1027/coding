package org.moi.algorithm.leecode.greedyalgorithm;

/**
 * @program:
 * @description: 45. ��Ծ��Ϸ II �Ѷȣ�hard
 * @author: moi
 * @create: 2020/12/29 21:13
 **/
public class CanJumpII {

    /**
     * ��Ŀ������һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
     *
     * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
     *
     * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
     *
     * ʾ��:
     *
     * ����: [2,3,1,1,4]
     * ���: 2
     * ����: �������һ��λ�õ���С��Ծ���� 2��
     * ?    ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã���?1?����Ȼ����?3?��������������һ��λ�á�
     * ˵��:
     *
     * ���������ǿ��Ե�����������һ��λ�á�
     *
     *
     */

    public int jump(int[] nums) {
        int length = nums.length;
        int steps = 0;
        int end = 0;
        int tmp = 0;
        for(int i = 0;i < length-1;i++){
            tmp = Math.max(tmp,i+nums[i]);
            if(i == end){
                end = tmp;
                steps++;
            }
        }
        return steps;
    }
}
