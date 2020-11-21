package org.moi.algorithm.leecode.doublepointer;

/**
 * @program:
 * @description: leeCode 第876题 链表的中间结点 难度： easy
 * @author: moi
 * @create: 2020/11/21 17:48
 **/
public class MiddleOfTheLinkedList {

    /**
     * 题目：给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     */

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        //判断中点，让快指针走的比慢指针快一倍，当快指针走到终点的时候，慢指针正好走到了中点
        while(fast !=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}
