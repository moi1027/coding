package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 101. �Գƶ����� �Ѷȣ�easy
 * @author: moi
 * @create: 2021/1/14 21:14
 **/
public class IsSymmetric {

    /**
     * ��Ŀ������һ����������������Ƿ��Ǿ���ԳƵġ�
     * ���磬������?[1,2,2,3,4,4,3] �ǶԳƵġ�
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * ?
     *
     * �����������?[1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     *
     */

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return compare(root.left,root.right);
    }


    public Boolean compare(TreeNode node1,TreeNode node2){
        if(node1 == null&&node2 ==null){
            return true;
        }
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return compare(node1.left,node2.right)&&compare(node1.right,node2.left);
    }
}
