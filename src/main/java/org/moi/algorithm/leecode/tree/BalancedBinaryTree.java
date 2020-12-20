package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 剑指 Offer 55 - II. 平衡二叉树 难度： easy
 * @author: moi
 * @create: 2020/12/20 22:21
 **/
public class BalancedBinaryTree {

    /**
     * 题目：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * 思路：套用二叉树的递归套路
     */


    /**
     * 先定义一个结构来存一个二叉树要成为平衡二叉树的几个条件
     */
    class Info{
        //树的高度
        public int height;
        //是否为平衡二叉树
        public boolean isBBT;
        public Info(int h,boolean bbt){
            this.height = h;
            this.isBBT = bbt;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBBt(root).isBBT;
    }

    public Info isBBt(TreeNode root){
        if(root == null){
            return new Info(0,true);
        }
        Info leftInfo = isBBt(root.left);
        Info rightInfo = isBBt(root.right);
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        boolean isBBt = false;
        if((Math.abs(leftInfo.height-rightInfo.height)<2)&&leftInfo.isBBT&&rightInfo.isBBT){
            isBBt = true;
        }
        return new Info(height,isBBt);
    }



}
