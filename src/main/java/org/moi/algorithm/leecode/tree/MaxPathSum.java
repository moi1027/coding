package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 124. �������е����·���� �Ѷȣ�hard
 * @author: moi
 * @create: 2021/1/15 22:22
 **/
public class MaxPathSum {

    /**
     * ��Ŀ��·�� ������Ϊһ������������ڵ�������ظ��ڵ�-�ӽڵ����ӣ��ﵽ����ڵ�����С���·�� ���ٰ���һ�� �ڵ㣬�Ҳ�һ���������ڵ㡣
     *
     * ·���� ��·���и��ڵ�ֵ���ܺ͡�
     *
     * ����һ���������ĸ��ڵ� root �������� ���·���� ��
     *
     * ?
     *
     * ʾ�� 1��
     *
     *
     * ���룺root = [1,2,3]
     * �����6
     * ���ͣ�����·���� 2 -> 1 -> 3 ��·����Ϊ 2 + 1 + 3 = 6
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
