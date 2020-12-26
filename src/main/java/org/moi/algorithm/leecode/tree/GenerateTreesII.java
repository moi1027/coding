package org.moi.algorithm.leecode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description: 95. ��ͬ�Ķ��������� II �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/26 22:28
 **/
public class GenerateTreesII {

    /**
     * ��Ŀ������һ������ n������������ 1 ... n Ϊ�ڵ�����ɵ� ���������� ��
     *
     * ʾ����
     *
     * ���룺3
     * �����
     * [
     * ? [1,null,3,2],
     * ? [3,2,null,1],
     * ? [3,1,null,null,2],
     * ? [2,1,3],
     * ? [1,null,2,null,3]
     * ]
     * ���ͣ�
     * ���ϵ������Ӧ���� 5 �ֲ�ͬ�ṹ�Ķ�����������
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     *
     */

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        return subGenerateTrees(1,n);
    }

    public List<TreeNode> subGenerateTrees(int start,int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        //ÿ����������Ϊ���ڵ�
        for(int i = start;i<=end;i++){
            List<TreeNode> leftTree = subGenerateTrees(start,i-1);
            List<TreeNode> rightTree = subGenerateTrees(i+1,end);
            for (TreeNode lTree:leftTree) {
                for(TreeNode rTree:rightTree){
                    //������ڵ�
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = lTree;
                    curNode.right = rTree;
                    allTrees.add(curNode);
                }
            }
        }
        return allTrees;
    }
}
