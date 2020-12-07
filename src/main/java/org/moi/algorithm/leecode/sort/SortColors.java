package org.moi.algorithm.leecode.sort;

import java.util.Random;

/**
 * @program:
 * @description: leeCode ��75��  ��ɫ���� �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/7 10:48
 **/
public class SortColors {

    /**
     * ��Ŀ������һ��������ɫ����ɫ����ɫ��һ��?n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
     *
     * �����У�����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
     *
     * ˼·������ ԭ���㷨����ѡ��������
     *
     */

    public static void sortColors(int[] nums) {
        if(nums.length == 0){
            return;
        }
        process(nums,0,nums.length-1);
    }

    public static void process(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        //�������һ����׼��
        int flag = (int)Math.random() * (r - l + 1);
        //����׼���ʹ�����������һ�������н���
        swap(arr,flag,r);
        int[] partition = partition(arr,l,r);
        process(arr,l,partition[0]-1);
        process(arr,partition[1]+1,r);
    }



    public static int[] partition(int[] arr,int l,int r){
        if(l>r){
            return new int[]{-1,-1};
        }
        if(l==r){
            return new int[]{l,r};
        }
        int less = l-1;
        int more = r;
        int index = l;
        while(index<more){
            if(arr[index] == arr[r]){
                index++;
            }else if(arr[index] > arr[r]){
                swap(arr,index,--more);
            }else{
                swap(arr,index++,++less);
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};

    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
    }
}
