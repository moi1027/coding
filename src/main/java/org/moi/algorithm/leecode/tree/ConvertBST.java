package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 538. �Ѷ���������ת��Ϊ�ۼ��� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/24 21:51
 **/
public class ConvertBST {

    /**
     * ��Ŀ���������� ���� ���ĸ��ڵ㣬�����Ľڵ�ֵ������ͬ�����㽫��ת��Ϊ�ۼ�����Greater Sum Tree����ʹÿ���ڵ� node?����ֵ����ԭ���д��ڻ����?node.val?��ֵ֮�͡�
     *
     * ����һ�£�������������������Լ��������
     *
     * �ڵ���������������� С�� �ڵ���Ľڵ㡣
     * �ڵ���������������� ���� �ڵ���Ľڵ㡣
     * ��������Ҳ�����Ƕ�����������
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
