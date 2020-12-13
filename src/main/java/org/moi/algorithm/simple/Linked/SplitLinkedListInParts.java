package org.moi.algorithm.simple.Linked;

/**
 * @program:
 * @description: ������Ŀ �ָ����� leeCode 725 �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/13 20:44
 **/
public class SplitLinkedListInParts {

    /**
     * ��Ŀ������һ��ͷ���Ϊ root ������, ��дһ�������Խ�����ָ�Ϊ k �������Ĳ��֡�
     *
     * ÿ���ֵĳ���Ӧ�þ����ܵ����: ���������ֵĳ��Ȳ�಻�ܳ��� 1��Ҳ����˵������Щ����Ϊ null��
     *
     * ��k������Ӧ�ð����������г��ֵ�˳������������������ǰ��Ĳ��ֵĳ���Ӧ�ô��ڻ���ں���ĳ��ȡ�
     *
     * ����һ���������������������б�
     *
     * ������ 1->2->3->4, k = 5 // 5 ��� [ [1], [2], [3], [4], null ]
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
