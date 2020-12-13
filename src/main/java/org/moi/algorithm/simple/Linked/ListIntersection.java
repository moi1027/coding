package org.moi.algorithm.simple.Linked;

/**
 * @program:
 * @description: 面试题 链表相交
 * @author: moi
 * @create: 2020/12/13 21:10
 **/
public class ListIntersection {

    /**
     * 题目：给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
     *
     * 假定两个链表没有环
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(l1 != null){
            len1++;
            l1 = l1.next;
        }
        while(l2 != null){
            len2++;
            l2 = l2.next;
        }
        l1 = headA;
        l2 = headB;
        if(len1>len2){
            int len = len1-len2;
            while(len>0){
                l1 = l1.next;
                len--;
            }
        }else{
            int len = len2-len1;
            while(len>0){
                l2 = l2.next;
                len--;
            }
        }
        while(l1!=null){
            if(l1.equals(l2)){
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

}
