package org.moi.algorithm.leecode.heap;

import java.util.PriorityQueue;

/**
 * @program:
 * @description: 剑指 Offer 41. 数据流中的中位数 难度： hard
 * @author: moi
 * @create: 2020/12/19 21:37
 **/
public class MedianFinder {


    /**
     * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     *
     * 思路，用两个堆来解决这个问题，一个是存较大值的小顶堆，一个是存较小值的大顶堆，两个堆的大小在插入的总数为奇数和为偶数的时候不一样
     */


    /**
     * 定义两个堆
     */
    PriorityQueue<Integer> A,B;
    public MedianFinder() {
        //java中提供的堆为小顶堆
        A = new PriorityQueue<>();
        //通过比较器的方式将堆转换位大顶堆
        B = new PriorityQueue<>((x,y)->(y-x));
    }

    public void addNum(int num) {
        //为啥要往B这个大顶堆先插入数据，由于当插入的总数是奇数的时候，我们需要去小顶堆的顶元素当做中位数，所以先插入B这个大顶堆中然后取出大顶堆的顶元素插入到A中，保证在A和B两个堆相同大小的情况下，下次插入A堆中会比B堆中多一个元素
        if(A.size()!=B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size()==B.size()?(A.peek()+B.peek())/2.0:A.peek();
    }


}
