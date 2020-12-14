package org.moi.algorithm.leecode.tree;

import sun.reflect.generics.tree.Tree;

import javax.print.attribute.IntegerSyntax;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program:
 * @description: leeCode 剑指offer 37 序列化二叉树
 * @author: moi
 * @create: 2020/12/14 20:25
 **/
public class BinaryTreeSerialization {

    /**
     * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。,题目要求用宽度优先遍历来序列化二叉树
     */

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        sb.append(root.val+",");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left!= null){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
            }
            if(!queue.isEmpty()){
                sb.append(treeNode.left==null?"null,":treeNode.left.val+",");
                sb.append(treeNode.right==null?"null,":treeNode.right.val+",");
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)){
            return null;
        }
        String[] strings = data.substring(1,data.length()-1).split(",");
        TreeNode node = new TreeNode(Integer.valueOf(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
           if(!"null".equals(strings[i])){
               TreeNode left = new TreeNode(Integer.parseInt(strings[i++]));
               treeNode.left = left;
               queue.add(left);
           }
           if(!"null".equals(strings[i])){
               TreeNode right = new TreeNode(Integer.parseInt(strings[i++]));
               treeNode.right = right;
               queue.add(right);
           }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        System.out.println(serialize(treeNode));
    }
}
