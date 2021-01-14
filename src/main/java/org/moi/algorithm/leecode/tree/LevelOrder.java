package org.moi.algorithm.leecode.tree;

import java.util.*;

/**
 * @program:
 * @description: 102. �������Ĳ������ �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/14 21:51
 **/
public class LevelOrder {

    /**
     * ��Ŀ������һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
     *
     * ?
     *
     * ʾ����
     * ��������[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * �����������������
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     *
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node1 = queue.poll();
                list.add(node1.val);
                if(node1.left != null) {
                    queue.add(node1.left);
                }
                if(node1.right != null) {
                    queue.add(node1.right);
                }
                count--;
            }
            lists.add(list);
        }

        return lists;
    }
}
