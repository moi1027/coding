package org.moi.algorithm.simple;

/**
 * @program:
 * @description: 单双链表
 * @author: moi
 * @create: 2020/11/15 20:52
 **/
public class TestList {

    public static class Node<T>{
        private T value;
        private Node<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public static class NodeDouble<T>{
        private T value;
        private NodeDouble next;
        private NodeDouble last;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public NodeDouble getNext() {
            return next;
        }

        public void setNext(NodeDouble next) {
            this.next = next;
        }

        public NodeDouble getLast() {
            return last;
        }

        public void setLast(NodeDouble last) {
            this.last = last;
        }
    }

    /**
     * 反转单链表
     * @param node
     * @return
     */
    public static Node reverseSingle(Node node){
        Node pre = null;
        Node next = null;
        while(node != null){
            next = node.next;
            node.next =pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 移除链表中给定的值，以单链表为例
     * @param head
     * @param value
     * @return
     */
    public static Node removeValue(Node head,Object value){
        //此层循环是为了当给定的值是头结点的值时可以直接移除头结点
        //直接到后续节点开始
        while(head != null){
            if(head.value != value){
                break;
            }
            head = head.next;
        }
        //head链表来到第一个不需要删的位置
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if(cur.value == value){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    /**
     * 反转双链表
     * @param head
     * @return
     */
    public static NodeDouble reverseDouble(NodeDouble head){
        NodeDouble pre = null;
        NodeDouble next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;

        }
        return pre;
    }


    public static void main(String[] args){
        Node<Integer> node = new Node<Integer>();
        Node<Integer> node1 = new Node<Integer>();
        Node<Integer> node2 = new Node<Integer>();
        Node<Integer> node3 = new Node<Integer>();
        Node<Integer> node4 = new Node<Integer>();
        node.setValue(5);
        node.setNext(node1);
        node1.setValue(4);
        node1.setNext(node2);
        node2.setValue(3);
        node2.setNext(node3);
        node3.setValue(2);
        node3.setNext(node4);
        node4.setValue(1);
        node4.setNext(null);
        //reverseSingle(node);

        removeValue(node,5);

//        NodeDouble<Integer> node0 = new NodeDouble<Integer>();
//        NodeDouble<Integer> node11 = new NodeDouble<Integer>();
//        NodeDouble<Integer> node12 = new NodeDouble<Integer>();
//        NodeDouble<Integer> node13 = new NodeDouble<Integer>();
//        NodeDouble<Integer> node14 = new NodeDouble<Integer>();
//        node0.setValue(5);
//        node0.setNext(node11);
//        node11.setValue(4);
//        node11.setNext(node12);
//        node12.setValue(3);
//        node12.setNext(node13);
//        node13.setValue(2);
//        node13.setNext(node14);
//        node14.setValue(1);
//        node14.setNext(null);
//        reverseDouble(node0);

    }
}
