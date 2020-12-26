package org.moi.algorithm.leecode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description: 95. 不同的二叉搜索树 II 难度：medium
 * @author: moi
 * @create: 2020/12/26 22:28
 **/
public class GenerateTreesII {

    /**
     * 题目：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     *
     * 示例：
     *
     * 输入：3
     * 输出：
     * [
     * ? [1,null,3,2],
     * ? [3,2,null,1],
     * ? [3,1,null,null,2],
     * ? [2,1,3],
     * ? [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     *
     */

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        return subGenerateTrees(1,n);
    }

    public List<TreeNode> subGenerateTrees(int start,int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        //每个数都可能为根节点
        for(int i = start;i<=end;i++){
            List<TreeNode> leftTree = subGenerateTrees(start,i-1);
            List<TreeNode> rightTree = subGenerateTrees(i+1,end);
            for (TreeNode lTree:leftTree) {
                for(TreeNode rTree:rightTree){
                    //构造根节点
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = lTree;
                    curNode.right = rTree;
                    allTrees.add(curNode);
                }
            }
        }
        return allTrees;
    }
}
