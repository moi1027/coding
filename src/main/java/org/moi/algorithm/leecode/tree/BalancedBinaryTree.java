package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: ��ָ Offer 55 - II. ƽ������� �Ѷȣ� easy
 * @author: moi
 * @create: 2020/12/20 22:21
 **/
public class BalancedBinaryTree {

    /**
     * ��Ŀ������һ�ö������ĸ��ڵ㣬�жϸ����ǲ���ƽ������������ĳ������������ڵ���������������������1����ô������һ��ƽ���������
     *
     * ˼·�����ö������ĵݹ���·
     */


    /**
     * �ȶ���һ���ṹ����һ��������Ҫ��Ϊƽ��������ļ�������
     */
    class Info{
        //���ĸ߶�
        public int height;
        //�Ƿ�Ϊƽ�������
        public boolean isBBT;
        public Info(int h,boolean bbt){
            this.height = h;
            this.isBBT = bbt;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBBt(root).isBBT;
    }

    public Info isBBt(TreeNode root){
        if(root == null){
            return new Info(0,true);
        }
        Info leftInfo = isBBt(root.left);
        Info rightInfo = isBBt(root.right);
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        boolean isBBt = false;
        if((Math.abs(leftInfo.height-rightInfo.height)<2)&&leftInfo.isBBT&&rightInfo.isBBT){
            isBBt = true;
        }
        return new Info(height,isBBt);
    }



}
