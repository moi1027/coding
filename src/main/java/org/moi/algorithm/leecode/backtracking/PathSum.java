package org.moi.algorithm.leecode.backtracking;

/**
 * @program:
 * @description: 437. ·���ܺ� III �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/25 11:09
 **/
public class PathSum {

    /**
     * ��Ŀ������һ��������������ÿ����㶼�����һ������ֵ��
     *
     * �ҳ�·���͵��ڸ�����ֵ��·��������
     *
     * ·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
     *
     * ������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������
     *
     * ʾ����
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * ���� 3���͵��� 8 ��·����:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     *
     */

    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        process(root,sum,0);
        return count;
    }

    public void process(TreeNode root,int target,int sum){
        if(root == null){
            return;
        }
        if(sum == target){
            count++;
            process(root,target,0);
        }else if(sum>target){
            process(root,target,0);
        }else {
            process(root.left, target, sum + root.val);
            process(root.right, target, sum + root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(new PathSum().pathSum(root,8));

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