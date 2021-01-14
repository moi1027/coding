package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 98. 验证二叉搜索树 难度：medium
 * @author: moi
 * @create: 2021/1/13 23:04
 **/
public class IsValidBST {

    /**
     * 题目：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例?1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     *
     *
     */
     static class TreeNode {
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

     public boolean isValidBST(TreeNode root) {
         return subIsValidBST(root,null,null);
     }

     public Boolean subIsValidBST(TreeNode root,Integer lower,Integer upper){
         if(root == null){
             return true;
         }
         int val = root.val;
         if(lower!=null && val<=lower){
             return false;
         }
         if(upper!=null&&val>=upper){
             return false;
         }
         if(!subIsValidBST(root.right,val,upper)){
             return false;
         }
         if(!subIsValidBST(root.left,lower,val)){
             return false;
         }
         return true;
     }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);
        new IsValidBST().isValidBST(treeNode);

    }
}
