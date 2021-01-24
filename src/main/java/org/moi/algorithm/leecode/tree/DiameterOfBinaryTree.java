package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 543. ��������ֱ�� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/24 21:19
 **/
public class DiameterOfBinaryTree {

    /**
     * ��Ŀ������һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ���Ҳ���ܲ���������㡣
     *
     * ?
     *
     * ʾ�� :
     * ����������
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * ����?3, ���ĳ�����·�� [4,2,1,3] ����?[5,2,1,3]��
     *
     *
     */

    int ans ;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        process(root);
        return ans-1;
    }

    public int process(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = process(node.left);
        int right = process(node.right);
        ans = Math.max(ans,left+right+1);
        return Math.max(left,right)+1;
    }
}
