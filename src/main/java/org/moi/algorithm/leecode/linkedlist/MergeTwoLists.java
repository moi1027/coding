package org.moi.algorithm.leecode.linkedlist;

/**
 * @program:
 * @description: 21. 合并两个有序链表 难度：easy
 * @author: moi
 * @create: 2021/1/6 20:44
 **/
public class MergeTwoLists {

    /**
     * 题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。?
     *
     * ?
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 思路：用两个指针来写
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode  init = new ListNode(0);
        if(l1 == null && l2 == null){
            return init.next;
        }
        ListNode res = init;
        ListNode l1node = l1;
        ListNode l2node = l2;
        while(l1node != null && l2node !=null){
            if(l1node.val<=l2node.val){
                res.next = l1node;
                l1node = l1node.next;
            }else{
                res.next = l2node;
                l2node = l2node.next;
            }
            res = res.next;
        }
        if(l1node != null){
            res.next = l1node;
        }
        if(l2node != null){
            res.next = l2node;
        }
        return init.next;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        //1->2->4, 1->3->4
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
         new MergeTwoLists().mergeTwoLists(l1,l2);

    }

}
