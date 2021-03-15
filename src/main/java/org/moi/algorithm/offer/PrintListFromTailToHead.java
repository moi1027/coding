package org.moi.algorithm.offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @program:
 * @description: 从尾到头打印链表 剑指 offer
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
     * 题目：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
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
