package org.moi.algorithm.leecode.doublepointer;

/**
 * @program:
 * @description: 11. ʢ���ˮ������ �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/5 20:51
 **/
public class ContainerWithMostWater {

    /**
     * ��Ŀ������ n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0) ���ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
     *
     * ˵�����㲻����б������
     * ���룺[1,8,6,2,5,4,8,3,7]
     * �����49
     * ���ͣ�ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ?49��
     *
     *
     *
     * ˼·����˫ָ����д
     */

    public int maxArea(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*Math.abs(left-right));
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        new ContainerWithMostWater().maxArea(nums);
    }
}
