package org.moi.algorithm.simple.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program:
 * @description: ����������� leeCode 662 �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/13 21:26
 **/
public class MaximumWidthOfBinaryTree {

    /**
     * ��Ŀ������һ������������дһ����������ȡ�����������ȡ����Ŀ�������в��е�����ȡ����������������������full binary tree���ṹ��ͬ����һЩ�ڵ�Ϊ�ա�
     *
     * ÿһ��Ŀ�ȱ�����Ϊ�����˵㣨�ò���������ҵķǿսڵ㣬���˵���null�ڵ�Ҳ���볤�ȣ�֮��ĳ��ȡ�
     *
     *˼·������һ�����������ÿ���ڵ㣬����һ���ڵ�Ӷ�����������ӽڵ�
     */

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(root,1);
        int curLevelNodes = 0;
        int curLevel = 1;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null) {
                int curNodeLevel = map.get(node);
                if (node.left != null) {
                    map.put(node.left, curNodeLevel + 1);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, curNodeLevel + 1);
                    queue.add(node.right);
                }
                if((node.left != null&&node.right == null)||(node.left == null&&node.right != null)){
                    curLevelNodes++;
                }
                if (curNodeLevel == curLevel) {
                    curLevelNodes++;
                } else {
                    max = Math.max(max, curLevelNodes);
                    curLevel++;
                    curLevelNodes = 1;
                }
            }
        }
        return Math.max(max,curLevelNodes);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
