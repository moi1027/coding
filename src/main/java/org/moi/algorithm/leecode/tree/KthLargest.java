package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点 难度：easy
 * @author: moi
 * @create: 2020/12/23 22:52
 **/
public class KthLargest {


    /**
     * 题目：给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * 思路，由于是一颗二叉搜索树，右大左小，所以就可以先遍历右边的在中间再左边，这样就是一个有序的遍历了
     */


    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        sort(root);
        return res;
    }

    public void sort(TreeNode root){
        if(root == null){
            return ;
        }
        sort(root.right);
        if(k == 0) return;
        if(--k == 0){
            res = root.val;
        }
        sort(root.left);
    }

}
