package org.moi.algorithm.simple.Linked;

import java.util.Stack;

/**
 * @program:
 * @description: 回文链表的解法 算法课第6课
 * @author: moi
 * @create: 2020/12/13 17:53
 **/
public class PalindromeList {


    /**
     * leeCode 题目：编写一个函数，检查输入的链表是否是回文的。
     *
     */


    /**
     * 解法一：在笔试中使用，不在意空间的消耗
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp != null){
            stack.push(tmp.value);
            tmp = tmp.next;
        }
        while(head != null){
            if(head.value == stack.pop()){
                head = head.next;
            }else{
                return false;
            }
        }
        return true;
    }


    /**
     * 优化：用快慢指针来解决，从中间位置来入栈，最后出栈对比链表的数据，如果一样则为回文结构
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while(fast.next != null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow!=null){
            stack.push(slow.value);
            slow = slow.next;
        }
        while(!stack.isEmpty()){
            if(head.value == stack.pop()){
                head = head.next;
            }else{
                return false;
            }
        }
        return true;
    }


    /**
     * 解法三： 让链表的后半部分往回指
     * @param head
     * @return
     */
    public static boolean isPalindrome3(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        // n1 中点


        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        ListNode n3 = null;
        while (n2 != null) { // right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        n3 = n1; // n3 -> save last node
        n2 = head;// n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;

    }

}

class ListNode{
    public int value;
    public ListNode next;
    public ListNode(int v){
        value = v;
    }
}
