package org.moi.algorithm.leecode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: 160. �ཻ���� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/20 21:31
 **/
public class GetIntersectionNode {

    /**
     * ��Ŀ����дһ�������ҵ������������ཻ����ʼ�ڵ㡣
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1 != null){
            map.put(l1,1);
            l1 = l1.next;
        }
        while(l2 != null){
            if(map.containsKey(l2)){
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }
}
