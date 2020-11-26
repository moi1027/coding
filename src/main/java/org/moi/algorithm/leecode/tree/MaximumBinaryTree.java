package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: leeCode 第 654 题 最大二叉树 难度：medium
 * @author: moi
 * @create: 2020/11/26 17:56
 **/
public class MaximumBinaryTree {


    /**
     * 题目：给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
     *
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
     *
     */

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return build(nums,0,nums.length-1);
    }

    public static TreeNode build(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int max = left;
        //求出数组在某一段区间内的最大值，将他作为下一段子树的根节点
        for(int i = left;i<=right;i++){
            if(nums[i]>nums[max]){
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        //数组区间最大的数的左边去构建它的左子树
        node.left = build(nums,left,max-1);
        //数组区间最大的数的左边去构建它的右子树
        node.right = build(nums,max+1,right);
        return node;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }

}
