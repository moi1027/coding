package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: leeCode ������ �������� �Ѷȣ� medium
 * @author: moi
 * @create: 2020/12/3 16:43
 **/
public class SubSort {

    /**
     * ��Ŀ������һ���������飬��дһ���������ҳ�����m��n��ֻҪ����������[m,n]��Ԫ���ź������������������ġ�ע�⣺n-m������С��Ҳ����˵���ҳ�����������������С���������ֵΪ[m,n]����������������m��n��������������������ģ����뷵��[-1,-1]��
     *
     */


    public static int[] subSort(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = Math.max(max, array[i]);
            }

            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[] {first, last};

    }

    public static void main(String[] args) {
        int[] array = {1,3,9,7,5};
        subSort(array);
    }
}
