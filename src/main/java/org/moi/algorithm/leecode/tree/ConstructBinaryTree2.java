package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: leeCode 第 106 题 从中序与后序遍历序列构造二叉树 难度：medium
 * @author: moi
 * @create: 2020/11/27 9:22
 **/
public class ConstructBinaryTree2 {

    /**
     *题目：根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     *
     * 知识点：前序遍历：中左右
     *       中序遍历：左中右
     *       后序遍历：左右中
     */

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public static TreeNode build(int[] inorder,int inStart,int inEnd,
                                 int[] postorder,int postStart,int postEnd){
        if(postStart > postEnd){
            return null;
        }
        int med = postorder[postEnd];
        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i] == med){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode node = new TreeNode(med);
        node.left = build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        node.right = build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return node;
    }


    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder,postorder);
    }

}
