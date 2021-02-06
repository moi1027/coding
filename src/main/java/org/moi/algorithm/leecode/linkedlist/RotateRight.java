package org.moi.algorithm.leecode.linkedlist;

/**
 * @program:
 * @description: 61. ��ת���� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/2/6 22:27
 **/
public class RotateRight {

    /**
     * ��Ŀ������һ��������ת����������ÿ���ڵ������ƶ�?k?��λ�ã�����?k?�ǷǸ�����
     *
     * ʾ��?1:
     *
     * ����: 1->2->3->4->5->NULL, k = 2
     * ���: 4->5->1->2->3->NULL
     * ����:
     * ������ת 1 ��: 5->1->2->3->4->NULL
     * ������ת 2 ��: 4->5->1->2->3->NULL
     * ʾ��?2:
     *
     * ����: 0->1->2->NULL, k = 4
     * ���: 2->0->1->NULL
     * ����:
     * ������ת 1 ��: 2->0->1->NULL
     * ������ת 2 ��: 1->2->0->NULL
     * ������ת 3 ��:?0->1->2->NULL
     * ������ת 4 ��:?2->0->1->NULL
     *
     *
     * ˼·������ָ��
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
