package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 104. 二叉树的最大深度 难度：easy
 * @author: moi
 * @create: 2021/1/15 22:37
 **/
public class MaxDepthII {

    /**
     * 题目：给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明:?叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度?3 。
     *
     *
     */

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(subMaxDepth(root.left),subMaxDepth(root.right))+1;
    }

    public int subMaxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = subMaxDepth(node.left);
        int right = subMaxDepth(node.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(5);
        System.out.println(new MaxDepthII().maxDepth(root));
    }
}
