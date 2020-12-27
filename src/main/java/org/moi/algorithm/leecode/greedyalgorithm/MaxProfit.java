package org.moi.algorithm.leecode.greedyalgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program:
 * @description: 122. 买卖股票的最佳时机 II 难度：easy
 * @author: moi
 * @create: 2020/12/27 23:35
 **/
public class MaxProfit {

    /**
     * 题目：给定一个数组，它的第?i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * ?    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * ?    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * ?    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例?3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     *思路：用贪心
     */



    static class DataInfo{
        private int price;
        private int day;
        public DataInfo(int p,int d){
            price = p;
            day = d;
        }
    }

    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        //建立一个小根堆
        PriorityQueue<DataInfo> priorityQueue = new PriorityQueue<>(new Comparator<DataInfo>() {
            @Override
            public int compare(DataInfo o1, DataInfo o2) {
                if(o1.price<o2.price){
                    return o2.day-o1.day;
                }else{
                    return o1.day-o2.day;
                }
            }
        });
        PriorityQueue<DataInfo> priorityQueue1 = new PriorityQueue<>(new Comparator<DataInfo>() {
            @Override
            public int compare(DataInfo o1, DataInfo o2) {
                if(o2.price>=o1.price){
                    if(o2.day>o1.day){
                        return o2.day-o1.day;
                    }else{
                        return o2.day-o1.day;
                    }
                }else{
                    return o2.day-o1.day;
                }
            }
        });
        int j = 1;
        for(int i:prices){
            priorityQueue.add(new DataInfo(i,j++));
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        maxProfit(arr);
    }
}
