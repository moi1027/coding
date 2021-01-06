package org.moi.algorithm.leecode.linkedlist;

/**
 * @program:
 * @description: 23. 合并K个升序链表 难度：hard
 * @author: moi
 * @create: 2021/1/6 21:33
 **/
public class MergeKSortedLists {

    /**
     * 题目：给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * ?
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *
     * 思路：用归并排序的思想来解决
     */

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }






    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
        ListNode l3 = new ListNode(2);
        ListNode l31 = new ListNode(6);
        l3.next = l31;
        ListNode[] listNodes = {l1,l2,l3};
        new MergeKSortedLists().mergeKLists(listNodes);
    }
}
