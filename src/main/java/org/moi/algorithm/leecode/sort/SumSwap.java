package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program:
 * @description: leeCode ������ ������ �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/3 15:58
 **/
public class SumSwap {

    /**
     *��Ŀ�� ���������������飬�뽻��һ����ֵ��ÿ��������ȡһ����ֵ����ʹ��������������Ԫ�صĺ���ȡ�
     *
     * ����һ�����飬��һ��Ԫ���ǵ�һ��������Ҫ������Ԫ�أ��ڶ���Ԫ���ǵڶ���������Ҫ������Ԫ�ء����ж���𰸣���������һ�����ɡ�����������������ֵ�����ؿ����顣
     *
     *
     * ˼·����˫ָ����
     */

    public static int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0 ;i<array1.length;i++){
            sum1+=array1[i];
        }
        for(int i = 0 ;i<array2.length;i++){
            sum2+=array2[i];
        }
        int i = 0;
        int j = 0;
        while(i<array1.length&&j<array2.length){
            if(sum1-array1[i]+array2[j]>sum2+array1[i]-array2[j]){
                i++;
            }else if(sum1-array1[i]+array2[j]<sum2+array1[i]-array2[j]){
                j++;
            }else{
                return new int[]{array1[i],array2[j]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] array1 = {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] array2 = {52, 20, 78, 50, 38, 96, 81, 20};
        findSwapValues(array1,array2);
    }
}
