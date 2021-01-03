package org.moi.algorithm.leecode.graph;

import java.util.*;

/**
 * @program:
 * @description: 133. ��¡ͼ �Ѷ� medium
 * @author: moi
 * @create: 2021/1/3 23:12
 **/
public class CloneGraph {

    /**
     * ��Ŀ����������?��ͨ?ͼ��һ���ڵ�����ã����㷵�ظ�ͼ��?�������¡����
     *
     * ͼ�е�ÿ���ڵ㶼��������ֵ val��int�� �����ھӵ��б�list[Node]����
     *
     * class Node {
     *     public int val;
     *     public List<Node> neighbors;
     * }
     * ?
     *
     * ����������ʽ��
     *
     * �������ÿ���ڵ��ֵ��������������ͬ�����磬��һ���ڵ�ֵΪ 1��val = 1�����ڶ����ڵ�ֵΪ 2��val = 2�����Դ����ơ���ͼ�ڲ���������ʹ���ڽ��б��ʾ��
     *
     * �ڽ��б� �����ڱ�ʾ����ͼ�������б�ļ��ϡ�ÿ���б�������ͼ�нڵ���ھӼ���
     *
     * �����ڵ㽫ʼ����ͼ�еĵ�һ���ڵ㣨ֵΪ 1��������뽫?�����ڵ�Ŀ���?��Ϊ�Կ�¡ͼ�����÷��ء�
     *
     *
     */


    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


            private HashMap<Node, Node> visited = new HashMap <> ();
            public  Node cloneGraph(Node node) {
                if (node == null) {
                    return node;
                }

                // ����ýڵ��Ѿ������ʹ��ˣ���ֱ�Ӵӹ�ϣ����ȡ����Ӧ�Ŀ�¡�ڵ㷵��
                if (visited.containsKey(node)) {
                    return visited.get(node);
                }

                // ��¡�ڵ㣬ע�⵽Ϊ��������ǲ����¡�����ھӵ��б�
                Node cloneNode = new Node(node.val, new ArrayList());
                // ��ϣ��洢
                visited.put(node, cloneNode);

                // �����ýڵ���ھӲ����¿�¡�ڵ���ھ��б�
                for (Node neighbor: node.neighbors) {
                    cloneNode.neighbors.add(cloneGraph(neighbor));
                }
                return cloneNode;
            }



    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        CloneGraph clone = new CloneGraph();
        clone.cloneGraph(node1);
    }

}
