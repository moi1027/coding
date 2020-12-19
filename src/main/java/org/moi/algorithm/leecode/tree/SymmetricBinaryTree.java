package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: ��ָ Offer 28. �ԳƵĶ����� �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/19 22:03
 **/
public class SymmetricBinaryTree {

    /**
     * ��Ŀ����ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô���ǶԳƵġ�
     *
     * ˼·���ж϶���������������ǰ������ܷ�����������ĺ������
     */

    public boolean isSymmetric(TreeNode root) {
        return root ==null?true:compare(root.left,root.right);
    }

    public  boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left == null || right == null||left.val!=right.val){
            return false;
        }
        return compare(left.left,right.right)&&compare(left.right,right.left);
    }
}
