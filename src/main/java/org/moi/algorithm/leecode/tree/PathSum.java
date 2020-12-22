package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description: 剑指 Offer 34. 二叉树中和为某一值的路径 难度：medium
 * @author: moi
 * @create: 2020/12/22 21:39
 **/
public class PathSum {

    /**
     * 题目：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 示例:
     * 给定如下二叉树，以及目标和?sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * 思路：用回溯思想
     */

    LinkedList<List<Integer>> lists = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        SubPathSum(root,sum);
        return lists;
    }

    public void SubPathSum(TreeNode node,int sum){
        if(node == null){
            return ;
        }
        list.add(node.val);
        sum-=node.val;
        if(sum == 0&& node.right==null&&node.left==null){
            lists.add(list);
        }
        SubPathSum(node.left,sum);
        SubPathSum(node.right,sum);
        list.removeLast();
    }


}
