package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 104. �������������� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/15 22:37
 **/
public class MaxDepthII {

    /**
     * ��Ŀ������һ�����������ҳ��������ȡ�
     *
     * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
     *
     * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
     *
     * ʾ����
     * ���������� [3,9,20,null,null,15,7]��
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * ��������������?3 ��
     *
     *
     */

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(subMaxDepth(root.left),subMaxDepth(root.right))+1;
    }

    public int subMaxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = subMaxDepth(node.left);
        int right = subMaxDepth(node.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(5);
        System.out.println(new MaxDepthII().maxDepth(root));
    }
}
