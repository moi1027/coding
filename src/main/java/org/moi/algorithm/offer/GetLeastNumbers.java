package org.moi.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program:
 * @description: ��СK����
 * @author: moi
 * @create: 2021/3/14 22:55
 **/
public class GetLeastNumbers {

    /**
     * ��Ŀ����ָoffer:����һ�����飬�ҳ�������С��K��������������Ԫ����4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4�����K>����ĳ��ȣ���ô����һ���յ�����
     *
     *
     * ��ҵ����Ѷ ����Ͱ� �ֽ�����
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
