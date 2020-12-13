package org.moi.algorithm.simple.Linked;

/**
 * @program:
 * @description: ������ �����ཻ
 * @author: moi
 * @create: 2020/12/13 21:10
 **/
public class ListIntersection {

    /**
     * ��Ŀ���������������������ж������Ƿ��ཻ�����ؽ��㡣��ע���ཻ�Ķ�����ڽڵ�����ã������ǻ��ڽڵ��ֵ�����仰˵�����һ������ĵ�k���ڵ�����һ������ĵ�j���ڵ���ͬһ�ڵ㣨������ȫ��ͬ�����������������ཻ��
     *
     * �ٶ���������û�л�
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(l1 != null){
            len1++;
            l1 = l1.next;
        }
        while(l2 != null){
            len2++;
            l2 = l2.next;
        }
        l1 = headA;
        l2 = headB;
        if(len1>len2){
            int len = len1-len2;
            while(len>0){
                l1 = l1.next;
                len--;
            }
        }else{
            int len = len2-len1;
            while(len>0){
                l2 = l2.next;
                len--;
            }
        }
        while(l1!=null){
            if(l1.equals(l2)){
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

}
