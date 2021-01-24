package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 538. 把二叉搜索树转换为累加树 难度：medium
 * @author: moi
 * @create: 2021/1/24 21:51
 **/
public class ConvertBST {

    /**
     * 题目：给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node?的新值等于原树中大于或等于?node.val?的值之和。
     *
     * 提醒一下，二叉搜索树满足下列约束条件：
     *
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     *
     *
     */

    int value;
    public TreeNode convertBST(TreeNode root) {
        process(root);
        return root;
    }

    public void process(TreeNode node){
        if(node == null){
            return;
        }
        process(node.right);
        node.val = value+node.val;
        value = node.val;
        process(node.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        new ConvertBST().convertBST(root);
    }
}
