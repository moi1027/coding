package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description: ��ָ Offer 34. �������к�Ϊĳһֵ��·�� �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/22 21:39
 **/
public class PathSum {

    /**
     * ��Ŀ������һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������Ľڵ��γ�һ��·����
     * ʾ��:
     * �������¶��������Լ�Ŀ���?sum = 22��
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * ����:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * ˼·���û���˼��
     */

    LinkedList<List<Integer>> lists = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        SubPathSum(root,sum);
        return lists;
    }

    public void SubPathSum(TreeNode node,int sum){
        if(node == null){
            return ;
        }
        list.add(node.val);
        sum-=node.val;
        if(sum == 0&& node.right==null&&node.left==null){
            lists.add(list);
        }
        SubPathSum(node.left,sum);
        SubPathSum(node.right,sum);
        list.removeLast();
    }


}
