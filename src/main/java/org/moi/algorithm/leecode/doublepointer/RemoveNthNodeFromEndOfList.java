package org.moi.algorithm.leecode.doublepointer;

/**
 * @program:
 * @description: leeCode 第19题 删除链表的倒数第N个节点 难度 中等
 * @author: moi
 * @create: 2020/11/21 17:55
 **/
public class RemoveNthNodeFromEndOfList {

    /**
     * 题目：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     *
     * 解法：同样用双指针，双指针同样可以运用于二分查找
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode low = head;
        while(fast != null && fast.next != null){
            if(n != 0){
                fast = fast.next;
                n--;
            }else{
                fast = fast.next;
                low = low.next;
            }
        }
        low.next = low.next.next;
        return head;
    }
}
