package org.moi.algorithm.offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @program:
 * @description: ��β��ͷ��ӡ���� ��ָ offer
 * @author: moi
 * @create: 2021/3/15 21:25
 **/
public class PrintListFromTailToHead {
     class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * ��Ŀ������һ�������������β��ͷ��˳�򷵻�һ��ArrayList��
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
