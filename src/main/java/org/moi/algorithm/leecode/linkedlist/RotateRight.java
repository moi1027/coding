package org.moi.algorithm.leecode.linkedlist;

/**
 * @program:
 * @description: 61. 旋转链表 难度：medium
 * @author: moi
 * @create: 2021/2/6 22:27
 **/
public class RotateRight {

    /**
     * 题目：给定一个链表，旋转链表，将链表每个节点向右移动?k?个位置，其中?k?是非负数。
     *
     * 示例?1:
     *
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例?2:
     *
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步:?0->1->2->NULL
     * 向右旋转 4 步:?2->0->1->NULL
     *
     *
     * 思路：快慢指针
     */

    public ListNode rotateRight(ListNode head, int k) {
        if(k ==0||head == null){
            return head;
        }
        ListNode l = head;
        ListNode r = head;
        ListNode q = head;
        int num = 0;
        while(q!=null){
            q = q.next;
            num++;
        }
        if(num == 1 && k>=1){
            return head;
        }
        if(k%num==0){
            return head;
        }
        for (int i = 0; i < k; i++) {

            r = r.next == null?head:r.next;

        }

        while(l.next != null && r.next != null){
            l = l.next;
            r = r.next;
        }

        ListNode res = l.next;
        l.next = null;
        r.next = head;
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(2);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
        new RotateRight().rotateRight(l1,4);
    }
}
