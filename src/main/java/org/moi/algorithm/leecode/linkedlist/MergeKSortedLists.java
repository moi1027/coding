package org.moi.algorithm.leecode.linkedlist;

/**
 * @program:
 * @description: 23. �ϲ�K���������� �Ѷȣ�hard
 * @author: moi
 * @create: 2021/1/6 21:33
 **/
public class MergeKSortedLists {

    /**
     * ��Ŀ������һ���������飬ÿ�������Ѿ����������С�
     *
     * ���㽫��������ϲ���һ�����������У����غϲ��������
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺lists = [[1,4,5],[1,3,4],[2,6]]
     * �����[1,1,2,3,4,4,5,6]
     * ���ͣ������������£�
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * �����Ǻϲ���һ�����������еõ���
     * 1->1->2->3->4->4->5->6
     * ʾ�� 2��
     *
     * ���룺lists = []
     * �����[]
     * ʾ�� 3��
     *
     * ���룺lists = [[]]
     * �����[]
     *
     * ˼·���ù鲢�����˼�������
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
