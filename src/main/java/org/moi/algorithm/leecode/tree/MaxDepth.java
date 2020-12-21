package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 剑指 Offer 55 - I. 二叉树的深度 难度 easy
 * @author: moi
 * @create: 2020/12/21 21:49
 **/
public class MaxDepth {

    /**
     * 题目：输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 例如：
     *
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度?3 。
     *
     * 思路：用二叉树递归套路解
     */


    /**
     * 用来存每课子树的深度
     */
    class DepthInfo{
        public int depth;
        public DepthInfo(int d){
            this.depth = d;
        }
    }

    public int maxDepth(TreeNode root) {
        return subDepth(root).depth;
    }


    public DepthInfo subDepth(TreeNode root){
        if(root == null){
            return new DepthInfo(0);
        }
        DepthInfo leftInfo = subDepth(root.left);
        DepthInfo rightInfo = subDepth(root.right);
        int maxDepth = Math.max(leftInfo.depth,rightInfo.depth)+1;
        return new DepthInfo(maxDepth);
    }
}
