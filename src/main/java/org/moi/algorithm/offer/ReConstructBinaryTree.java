package org.moi.algorithm.offer;

/**
 * @program:
 * @description: 剑指offer 重建二叉树
 * @author: moi
 * @create: 2021/3/15 21:30
 **/
public class ReConstructBinaryTree {

      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    /**
     * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null){
            return null;
        }
        return buildTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode buildTree(int[] pre,int leftStart,int leftEnd,int[] in,int rightStart,int rightEnd){
        if(leftEnd<leftStart){
            return null;
        }
        TreeNode node = new TreeNode(pre[leftStart]);
        int mod = 0;
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[leftStart]){
                mod = i;
                break;
            }
        }
        int leftSize = mod - rightStart;
        node.left = buildTree(pre,leftStart+1,leftStart+leftSize,in,rightStart,mod-1);
        node.right = buildTree(pre,leftStart+leftSize+1,leftEnd,in,mod+1,rightEnd);
        return node;
    }




    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = new ReConstructBinaryTree().reConstructBinaryTree(pre,in);
        System.out.println(node.val);
    }

}
