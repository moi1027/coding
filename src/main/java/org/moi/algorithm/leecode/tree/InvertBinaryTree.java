package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: leeCode 第 226 题 翻转二叉树 难度： easy
 * @author: moi
 * @create: 2020/11/25 20:40
 **/
public class InvertBinaryTree {

    /**
     * 题目：翻转一棵二叉树。
     * 就相当于对一棵树进行镜像翻转
     */


    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        //设置一个中间变量，将二叉树的左右两个节点进行交换
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
