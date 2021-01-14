package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 98. ��֤���������� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/13 23:04
 **/
public class IsValidBST {

    /**
     * ��Ŀ������һ�����������ж����Ƿ���һ����Ч�Ķ�����������
     *
     * ����һ��������������������������
     *
     * �ڵ��������ֻ����С�ڵ�ǰ�ڵ������
     * �ڵ��������ֻ�������ڵ�ǰ�ڵ������
     * �������������������������Ҳ�Ƕ�����������
     * ʾ��?1:
     *
     * ����:
     *     2
     *    / \
     *   1   3
     * ���: true
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
