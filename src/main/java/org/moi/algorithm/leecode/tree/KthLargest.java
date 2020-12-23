package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: ��ָ Offer 54. �����������ĵ�k��ڵ� �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/23 22:52
 **/
public class KthLargest {


    /**
     * ��Ŀ������һ�ö��������������ҳ����е�k��Ľڵ㡣
     *
     * ˼·��������һ�Ŷ������������Ҵ���С�����ԾͿ����ȱ����ұߵ����м�����ߣ���������һ������ı�����
     */


    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        sort(root);
        return res;
    }

    public void sort(TreeNode root){
        if(root == null){
            return ;
        }
        sort(root.right);
        if(k == 0) return;
        if(--k == 0){
            res = root.val;
        }
        sort(root.left);
    }

}
