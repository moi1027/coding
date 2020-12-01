package org.moi.algorithm.leecode.linkedlist;

/**
 * @program:
 * @description: leeCode 合并两个链表
 * @author: moi
 * @create: 2020/12/1 20:54
 **/
public class TwoLink {

    /**
     * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sortList = new ListNode(0);
        ListNode cur = sortList;
        while(l1 !=null && l2!= null){
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return sortList.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1,l2);
    }

}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
