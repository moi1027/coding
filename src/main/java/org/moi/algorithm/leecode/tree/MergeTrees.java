package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 617. �ϲ������� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/24 20:15
 **/
public class MergeTrees {

    /**
     * ��Ŀ�����������������������㽫�����е�һ�����ǵ���һ����ʱ��������������һЩ�ڵ����ص���
     *
     * ����Ҫ�����Ǻϲ�Ϊһ���µĶ��������ϲ��Ĺ�������������ڵ��ص�����ô�����ǵ�ֵ�����Ϊ�ڵ�ϲ������ֵ������Ϊ?NULL �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
     *
     * ʾ��?1:
     *
     * ����:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * ���:
     * �ϲ������:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * ע��:?�ϲ�������������ĸ��ڵ㿪ʼ
     *
     *
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null&&t2==null){
            return null;
        }
        if(t1 != null && t2 == null){
            return t1;
        }
        if(t1 == null && t2 != null){
            return t2;
        }
        subProcess(t1,t2);
        return t1;
    }

    public TreeNode subProcess(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 != null) {
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val = t1.val+t2.val;
        t1.left = subProcess(t1.left,t2.left);
        t1.right = subProcess(t1.right,t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        new MergeTrees().mergeTrees(t1,t2);
    }
}
