package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 剑指 Offer 68 - II. 二叉树的最近公共祖先 难度：easy
 * @author: moi
 * @create: 2020/12/21 22:00
 **/
public class LowestCommonAncestor {

    /**
     * 题目：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:? root =?[3,5,1,6,2,0,8,null,null,7,4]
     *
     *示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     *
     * 思路：用二叉树递归套路来解决
     *
     */

    /**
     * 每颗子树找到了两个节点的公共祖先的可能性
     * 1.公共祖先的节点
     * 2.子树包含p
     * 3.子树包含q
     */
    class AncestorInfo{
        public TreeNode node;
        public boolean ispAncestor;
        public boolean isqAncestor;
        public AncestorInfo(TreeNode n,boolean isFindP,boolean isFindQ){
            this.node = n;
            this.ispAncestor = isFindP;
            this.isqAncestor = isFindQ;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestCommonAncestor(root,p,q).node;
    }

    public AncestorInfo findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return new AncestorInfo(null,false,false);
        }
        AncestorInfo leftInfo = findLowestCommonAncestor(root.left,p,q);
        AncestorInfo rightInfo = findLowestCommonAncestor(root.right,p,q);
        TreeNode AncestorNode = null;
        boolean findP = root == p||leftInfo.ispAncestor||rightInfo.ispAncestor;
        boolean findQ = root == p||leftInfo.isqAncestor||rightInfo.isqAncestor;
        if(leftInfo.node != null){
            AncestorNode = leftInfo.node;
        }
        if(rightInfo.node != null){
            AncestorNode = rightInfo.node;
        }
        if(AncestorNode == null){
            if(findP&&findQ){
                AncestorNode = root;
            }
        }
        return new AncestorInfo(AncestorNode,findP,findQ);
    }
}
