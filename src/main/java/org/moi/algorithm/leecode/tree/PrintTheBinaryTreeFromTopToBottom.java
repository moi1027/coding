package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树 难度：easy
 * @author: moi
 * @create: 2020/12/20 22:47
 **/
public class PrintTheBinaryTreeFromTopToBottom {

    /**
     * 题目：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     * 例如:
     * 给定二叉树:?[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：
     *
     * [3,9,20,15,7]
     *
     * 思路：宽度遍历
     */

    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
                list.add(node.left.val);
            }
            if(node.right!=null){
                queue.add(node.right);
                list.add(node.right.val);
            }
        }
        int[] nums = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
