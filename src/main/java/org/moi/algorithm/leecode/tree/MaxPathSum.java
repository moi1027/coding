package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 124. 二叉树中的最大路径和 难度：hard
 * @author: moi
 * @create: 2021/1/15 22:22
 **/
public class MaxPathSum {

    /**
     * 题目：路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径 至少包含一个 节点，且不一定经过根节点。
     *
     * 路径和 是路径中各节点值的总和。
     *
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     *
     * ?
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,3]
     * 输出：6
     * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
     *
     *
     */

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        subMaxPathSum(root);
        return res;
    }

    public int subMaxPathSum(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,subMaxPathSum(node.left));
        int right = Math.max(0,subMaxPathSum(node.right));
        res = Math.max(res,node.val+left+right);
        return Math.max(left,right)+node.val;
    }
}
