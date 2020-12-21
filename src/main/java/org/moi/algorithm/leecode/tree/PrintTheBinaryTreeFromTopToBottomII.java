package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description: ��ָ Offer 32 - II. ���ϵ��´�ӡ������ II �Ѷ� easy
 * @author: moi
 * @create: 2020/12/21 21:11
 **/
public class PrintTheBinaryTreeFromTopToBottomII {

    /**
     * ��Ŀ��  ���ϵ��°����ӡ��������ͬһ��Ľڵ㰴�����ҵ�˳���ӡ��ÿһ���ӡ��һ�С�
     * ����:
     * ����������:?[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * �������α��������
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * ˼·���ÿ�����ȱ���
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
