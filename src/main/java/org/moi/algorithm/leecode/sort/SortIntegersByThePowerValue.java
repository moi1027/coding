package org.moi.algorithm.leecode.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program:
 * @description: leeCode 1387 将整数按权重排序 难度：medium
 * @author: moi
 * @create: 2020/12/4 22:26
 **/
public class SortIntegersByThePowerValue {


    /**
     * 题目：我们将整数 x?的 权重 定义为按照下述规则将 x?变成 1?所需要的步数：
     *
     * 如果?x?是偶数，那么 x = x / 2
     * 如果?x?是奇数，那么?x = 3 * x + 1
     * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
     *
     * 给你三个整数?lo，?hi 和?k?。你的任务是将区间?[lo, hi]?之间的整数按照它们的权重?升序排序?，如果大于等于 2 个整数有?相同?的权重，那么按照数字自身的数值?升序排序?。
     *
     * 请你返回区间?[lo, hi]?之间的整数按权重排序后的第?k?个数。
     *
     * 注意，题目保证对于任意整数?x?（lo <= x <= hi）?，它变成?1 所需要的步数是一个 32 位有符号整数。
     *
     * 思路：用比较器的方式来做
     */

    public static int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        int n = lo;
        for(int i = 0;i<=hi-lo;i++){
            list.add(n);
            n++;
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(count(o1,0)>count(o2,0)){
                    return 1;
                }else if(count(o1,0)<count(o2,0)){
                    return -1;
                }else{
                    return o1>o2?1:-1;
                }
            }
        });

        return list.get(k-1);
    }

    public static int count(Integer num,Integer count){
        while(num != 1){
            if(num % 2 == 0){
                num = num/2;
                count++;
            }else if(num % 2 !=0){
                num = 3*num +1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int lo = 1,hi = 1000;
        System.out.println(getKth(lo,hi,777));
    }
}
