package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program:
 * @description: ��ָ Offer 32 - I. ���ϵ��´�ӡ������ �Ѷȣ�easy
 * @author: moi
 * @create: 2020/12/20 22:47
 **/
public class PrintTheBinaryTreeFromTopToBottom {

    /**
     * ��Ŀ�����ϵ��´�ӡ����������ÿ���ڵ㣬ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ��
     *
     * ����:
     * ����������:?[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * ���أ�
     *
     * [3,9,20,15,7]
     *
     * ˼·����ȱ���
     */

    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
                list.add(node.left.val);
            }
            if(node.right!=null){
                queue.add(node.right);
                list.add(node.right.val);
            }
        }
        int[] nums = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
