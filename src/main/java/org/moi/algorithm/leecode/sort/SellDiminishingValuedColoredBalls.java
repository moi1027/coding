package org.moi.algorithm.leecode.sort;

import java.util.Arrays;

/**
 * @program:
 * @description: ���ۼ�ֵ���ٵ���ɫ�� �Ѷȣ�medium leeCode 1648
 * @author: moi
 * @create: 2020/12/15 21:50
 **/
public class SellDiminishingValuedColoredBalls {

    /**
     * ��Ŀ������һЩ��Ŀ��?inventory?����������Ų�ͬ��ɫ����һ���˿���Ҫ?������ɫ ����Ϊ?orders?����
     *
     * ��λ�˿���һ������ķ�ʽ������ļ�ֵ��ÿ����ļ�ֵ��Ŀǰʣ�µ�?ͬɫ��?����Ŀ���ȷ�˵��ʣ��?6?��������ô�˿����һ�������ʱ��û���ļ�ֵΪ?6?����ʽ����Ժ�ֻʣ��?5?�������ˣ�������һ������ļ�ֵΪ?5?��Ҳ������ļ�ֵ���Ź˿͹���ͬɫ���ǵݼ��ģ�
     *
     * ������������?inventory?������?inventory[i]?��ʾ��?i?����ɫ��һ��ʼ����Ŀ��ͬʱ��������?orders?����ʾ�˿��ܹ����������Ŀ������԰��� ����˳��?����
     *
     * ���㷵������ orders?�����Ժ� ���?�ܼ�ֵ֮�͡����ڴ𰸿��ܻ�ܴ����㷵�ش𰸶� 109?+ 7?ȡ����?�Ľ����
     *
     * ˼·���Ƚ����е�����������Ȼ����ҵ�һ��Ԫ���ܱ�֤ �������Ԫ��֮������еݼ������ӵ���orders
     */

    public static int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int right = inventory[inventory.length-1];
        int left = 0;
        int mid = (left+right)/2;
        int tmp = 0;
        while(left<=right){
            if(orders>=count(inventory,mid)){
                tmp = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
            mid = (left+right)/2;
        }
        int res = orders-count(inventory,tmp);
        long result = 0;
        for(int i:inventory){
            if(i>tmp){
                if(res>0){
                    result += (long)(i+tmp)*(i-tmp+1)/2;
                    res--;
                }else{
                    result += (long)(i+tmp+1)*(i-tmp)/2;
                }
            }
        }
        int mod = (int)Math.pow(10,9)+7;
        return (int)(result%mod);
    }


    public static int count(int[] arr,int limit){
       int count = 0;
       for(int l:arr){
           if(l>=limit){
               count += l-limit;
           }
       }
       return count;
    }

    public static void main(String[] args) {
        int[] arr = {1000000000};
        maxProfit(arr,1000000000);
    }
}
