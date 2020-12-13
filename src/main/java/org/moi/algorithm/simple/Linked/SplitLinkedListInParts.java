package org.moi.algorithm.simple.Linked;

/**
 * @program:
 * @description: 链表题目 分隔链表 leeCode 725 难度：medium
 * @author: moi
 * @create: 2020/12/13 20:44
 **/
public class SplitLinkedListInParts {

    /**
     * 题目：给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
     *
     * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
     *
     * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
     *
     * 返回一个符合上述规则的链表的列表。
     *
     * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
     *
     */

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode node = root;
        while(node != null){
            node = node.next;
            len ++;
        }
        int size = len<k?1:len/k;
        int plus = len<k?0:len%k;
        node = root;
        ListNode[] listNodes = new ListNode[k];
        int j = 1;
        int n = len;
        ListNode tmp = null;
        for(int i = 0;i<k;i++){
            if(node != null){
                listNodes[i] = node;
            }else{
                listNodes[i] = null;
            }

            j=1;
            if(plus>0){
                n = size+1;
                plus--;
            }else{
                n = size;
            }
            if(node != null) {
                while (j < n) {
                    node = node.next;
                    j++;
                }
                tmp = node.next;
                node.next = null;
                node = tmp;
            }else{
                node = null;
            }
        }
        return listNodes;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=null;
        splitListToParts(l1,5);

    }
}
