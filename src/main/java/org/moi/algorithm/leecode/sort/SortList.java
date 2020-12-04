package org.moi.algorithm.leecode.sort;

/**
 * @program:
 * @description: leeCode 第148题 排序链表 难度：medium
 * @author: moi
 * @create: 2020/12/4 22:01
 **/
public class SortList {

    /**
     * 题目：给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
     *
     *
     * 归并排序
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
        //用快慢指针找到链表的中点
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
