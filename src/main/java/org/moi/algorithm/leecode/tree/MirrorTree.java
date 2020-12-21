package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: ��ָ Offer 27. �������ľ��� �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/21 21:33
 **/
public class MirrorTree {

    /**
     * ��Ŀ�������һ������������һ�����������ú���������ľ���
     *
     * �������룺
     *
     * ? ? ?4
     * ? ?/ ? \
     * ? 2 ? ? 7
     * ?/ \ ? / \
     * 1 ? 3 6 ? 9
     * ���������
     *
     * ? ? ?4
     * ? ?/ ? \
     * ? 7 ? ? 2
     * ?/ \ ? / \
     * 9 ? 6 3? ?1
     *
     * ?
     *
     * ˼·��������������
     */



    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode r = mirrorTree(root);
        TreeNode r1 = r.right;
    }
}
