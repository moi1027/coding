package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: leeCode ��148�� �������� �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/4 22:01
 **/
public class SortList {

    /**
     * ��Ŀ�����������ͷ��� head ���뽫�䰴 ���� ���в����� ����������
     *
     *
     * �鲢����
     */

    public static ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    public static ListNode sortList(ListNode head,ListNode tail) {
        if(head == null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        //�ÿ���ָ���ҵ�������е�
        ListNode fast = head,low = head;
        while(fast != tail){
            fast = fast.next;
            low = low.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = low;
        ListNode list1 = sortList(head,mid);
        ListNode list2 = sortList(mid,tail);
        ListNode sorted = merge(list1,list2);
        return sorted;
    }


    public static ListNode merge(ListNode list1,ListNode list2){
       ListNode sorted = new ListNode(0);
       ListNode tmp = sorted,tmp1 = list1,tmp2 = list2;
       while(tmp1 != null && tmp2 != null){
           if(tmp1.val<tmp2.val){
               tmp.next = tmp1;
               tmp1 = tmp1.next;
           }else{
               tmp.next = tmp2;
               tmp2 = tmp2.next;
           }
           tmp = tmp.next;
       }
       if(tmp1 != null){
           tmp.next = tmp1;
       }
       if(tmp2 != null){
           tmp.next = tmp2;
       }
       return sorted.next;
    }



}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
