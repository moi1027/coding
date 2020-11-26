package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: leeCode 第105题 从前序与中序遍历序列构造二叉树 难度：medium
 * @author: moi
 * @create: 2020/11/26 21:42
 **/
public class ConstructBinaryTree {


    /**
     * 题目：根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     */

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null){
            return null;
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static TreeNode build(int[] pre,int preStart,int preEnd,
                                 int[] inorder,int inStart,int inEnd){
        //当子树的起始下标大于终点下标时候，就要结束构建
        if(preStart>preEnd){
            return null;
        }
        int med = pre[preStart];
        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(med == inorder[i]){
                index = i;
                break;
            }
        }
        int leftSize = index-inStart;
        TreeNode node = new TreeNode(med);
        //构建左子树，需要前序遍历的左子树的区间和中序遍历的左子树的区间，依次递归
        node.left = build(pre,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        //构建右子树，需要前序遍历的右子树的区间和中序遍历的右子树的区间，依次递归
        node.right = build(pre,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return node;
    }


    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder,inorder);
    }

}
