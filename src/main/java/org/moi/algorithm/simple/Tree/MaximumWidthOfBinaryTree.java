package org.moi.algorithm.simple.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program:
 * @description: 二叉树最大宽度 leeCode 662 难度：medium
 * @author: moi
 * @create: 2020/12/13 21:26
 **/
public class MaximumWidthOfBinaryTree {

    /**
     * 题目：给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
     *
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     *
     *思路：设置一个队列来存放每个节点，弹出一个节点从而来加入其的子节点
     */

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(root,1);
        int curLevelNodes = 0;
        int curLevel = 1;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null) {
                int curNodeLevel = map.get(node);
                if (node.left != null) {
                    map.put(node.left, curNodeLevel + 1);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, curNodeLevel + 1);
                    queue.add(node.right);
                }
                if((node.left != null&&node.right == null)||(node.left == null&&node.right != null)){
                    curLevelNodes++;
                }
                if (curNodeLevel == curLevel) {
                    curLevelNodes++;
                } else {
                    max = Math.max(max, curLevelNodes);
                    curLevel++;
                    curLevelNodes = 1;
                }
            }
        }
        return Math.max(max,curLevelNodes);
    }
}
class TreeNode {
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
