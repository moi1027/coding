package org.moi.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program:
 * @description: 最小K个数
 * @author: moi
 * @create: 2021/3/14 22:55
 **/
public class GetLeastNumbers {

    /**
     * 题目：剑指offer:给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
     *
     *
     * 企业：腾讯 阿里巴巴 字节跳动
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
