package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 剑指 Offer 28. 对称的二叉树 难度：easy
 * @author: moi
 * @create: 2020/12/19 22:03
 **/
public class SymmetricBinaryTree {

    /**
     * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 思路：判断二叉树的左子树的前序遍历能否等于右子树的后序遍历
     */

    public boolean isSymmetric(TreeNode root) {
        return root ==null?true:compare(root.left,root.right);
    }


    public  boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left == null || right == null||left.val!=right.val){
            return false;
        }
        return compare(left.left,right.right)&&compare(left.right,right.left);
    }
}
