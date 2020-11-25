package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: leeCode 第116题  填充每个节点的下一个右侧节点指针 难度： medium
 * @author: moi
 * @create: 2020/11/25 20:57
 **/
public class PopulatingNextRightPointersInEachNode {

    /**
     * 题目：给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     *
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     */

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        connectTwo(root.left,root.right);
        return root;
    }

    public static void connectTwo(Node left,Node right){
        if(left == null || right == null){
            return;
        }
        left.next = right;
        connectTwo(left.left,left.right);
        connectTwo(right.left,right.right);
        //解决两个子树之间的连接不到的问题
        connectTwo(left.right,right.left);
    }


}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
