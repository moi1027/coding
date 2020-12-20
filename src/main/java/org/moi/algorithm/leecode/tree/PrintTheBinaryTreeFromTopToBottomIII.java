package org.moi.algorithm.leecode.tree;

import java.util.*;

/**
 * @program:
 * @description: ��ָ Offer 32 - III. ���ϵ��´�ӡ������ III �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/20 22:57
 **/
public class PrintTheBinaryTreeFromTopToBottomIII {

    /**
     * ��Ŀ����ʵ��һ����������֮����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��ҵ����˳���ӡ���������ٰ��մ����ҵ�˳���ӡ���������Դ����ơ�
     *
     *
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
     *   [20,9],
     *   [15,7]
     * ]
     *
     *
     * ˼·���������Ŀ�ȱ���
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0){
                    tmp.addLast(node.val); // ż���� -> ����ͷ��
                }else {
                    tmp.addFirst(node.val); // ������ -> ����β��
                }
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
