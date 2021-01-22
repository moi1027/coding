package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: ��ָ Offer 68 - II. ������������������� �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/21 22:00
 **/
public class LowestCommonAncestor {

    /**
     * ��Ŀ������һ��������, �ҵ�����������ָ���ڵ������������ȡ�
     *
     * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
     *
     * ���磬�������¶�����:? root =?[3,5,1,6,2,0,8,null,null,7,4]
     *
     *ʾ�� 1:
     *
     * ����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * ���: 3
     * ����: �ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3��
     *
     * ˼·���ö������ݹ���·�����
     *
     */

    /**
     * ÿ�������ҵ��������ڵ�Ĺ������ȵĿ�����
     * 1.�������ȵĽڵ�
     * 2.��������p
     * 3.��������q
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
        boolean findQ = root == q||leftInfo.isqAncestor||rightInfo.isqAncestor;
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
