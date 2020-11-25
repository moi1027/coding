package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: leeCode 第 114 题 二叉树展开为链表 难度： medium
 * @author: moi
 * @create: 2020/11/25 21:11
 **/
public class FlattenBinaryTreeToLinkedList {
    /**
     * 题目：给定一个二叉树，原地将它展开为一个单链表。
     *
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        flattening(root,list);
        TreeNode tmp = root;
        for(int i = 1;i<list.size();i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    /**
     * 设定一个list数组，让节点root以前序遍历的方式来将节点读取写到list中
     * @param root
     * @param list
     */
    public static void flattening(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        flattening(root.left,list);
        flattening(root.right,list);
    }
}


