package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 101. 对称二叉树 难度：easy
 * @author: moi
 * @create: 2021/1/14 21:14
 **/
public class IsSymmetric {

    /**
     * 题目：给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树?[1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * ?
     *
     * 但是下面这个?[1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     *
     */

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return compare(root.left,root.right);
    }


    public Boolean compare(TreeNode node1,TreeNode node2){
        if(node1 == null&&node2 ==null){
            return true;
        }
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return compare(node1.left,node2.right)&&compare(node1.right,node2.left);
    }
}
