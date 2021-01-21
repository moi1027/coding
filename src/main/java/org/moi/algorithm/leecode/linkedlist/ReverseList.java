package org.moi.algorithm.leecode.linkedlist;

/**
 * @program:
 * @description: 206. ��ת���� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/21 12:11
 **/
public class ReverseList {

    /**
     * ��Ŀ����תһ��������
     *
     * ʾ��:
     *
     * ����: 1->2->3->4->5->NULL
     * ���: 5->4->3->2->1->NULL
     * ����:
     * ����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿
     *
     *
     */


    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode tail = head;
        while(true){
            if(tail.next !=null){
                tail = tail.next;
            }else{
                break;
            }
        }
        subReverse(head);
        return tail;
    }

    public ListNode subReverse(ListNode node){
        if(node == null){
            return null;
        }
        ListNode listNode = node;

        ListNode nextNode = node.next;
        listNode.next = null;
        if(nextNode!=null) {
            ListNode listNode1 = subReverse(nextNode);
            listNode1.next= listNode;
        }

        return listNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        new ReverseList().reverseList(l1);
    }

}
