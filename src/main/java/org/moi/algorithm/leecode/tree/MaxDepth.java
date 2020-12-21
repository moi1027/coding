package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: ��ָ Offer 55 - I. ����������� �Ѷ� easy
 * @author: moi
 * @create: 2020/12/21 21:49
 **/
public class MaxDepth {

    /**
     * ��Ŀ������һ�ö������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
     *
     * ���磺
     *
     * ���������� [3,9,20,null,null,15,7]��
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * ��������������?3 ��
     *
     * ˼·���ö������ݹ���·��
     */


    /**
     * ������ÿ�����������
     */
    class DepthInfo{
        public int depth;
        public DepthInfo(int d){
            this.depth = d;
        }
    }

    public int maxDepth(TreeNode root) {
        return subDepth(root).depth;
    }


    public DepthInfo subDepth(TreeNode root){
        if(root == null){
            return new DepthInfo(0);
        }
        DepthInfo leftInfo = subDepth(root.left);
        DepthInfo rightInfo = subDepth(root.right);
        int maxDepth = Math.max(leftInfo.depth,rightInfo.depth)+1;
        return new DepthInfo(maxDepth);
    }
}
