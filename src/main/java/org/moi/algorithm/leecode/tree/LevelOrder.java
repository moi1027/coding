package org.moi.algorithm.leecode.tree;

import java.util.*;

/**
 * @program:
 * @description: 102. 二叉树的层序遍历 难度：medium
 * @author: moi
 * @create: 2021/1/14 21:51
 **/
public class LevelOrder {

    /**
     * 题目：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * ?
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层序遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     *
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node1 = queue.poll();
                list.add(node1.val);
                if(node1.left != null) {
                    queue.add(node1.left);
                }
                if(node1.right != null) {
                    queue.add(node1.right);
                }
                count--;
            }
            lists.add(list);
        }

        return lists;
    }
}
