package org.moi.algorithm.leecode.sort;

import java.util.Arrays;

/**
 * @program:
 * @description: 销售价值减少的颜色球 难度：medium leeCode 1648
 * @author: moi
 * @create: 2020/12/15 21:50
 **/
public class SellDiminishingValuedColoredBalls {

    /**
     * 题目：你有一些球的库存?inventory?，里面包含着不同颜色的球。一个顾客想要?任意颜色 总数为?orders?的球。
     *
     * 这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的?同色球?的数目。比方说还剩下?6?个黄球，那么顾客买第一个黄球的时候该黄球的价值为?6?。这笔交易以后，只剩下?5?个黄球了，所以下一个黄球的价值为?5?（也就是球的价值随着顾客购买同色球是递减的）
     *
     * 给你整数数组?inventory?，其中?inventory[i]?表示第?i?种颜色球一开始的数目。同时给你整数?orders?，表示顾客总共想买的球数目。你可以按照 任意顺序?卖球。
     *
     * 请你返回卖了 orders?个球以后 最大?总价值之和。由于答案可能会很大，请你返回答案对 109?+ 7?取余数?的结果。
     *
     * 思路：先将所有的数进行排序，然后对找到一个元素能保证 最大项到这个元素之间的所有递减差和相加等于orders
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
