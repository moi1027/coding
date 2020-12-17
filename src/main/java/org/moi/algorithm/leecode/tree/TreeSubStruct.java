package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: 剑指offer 树的子结构 难度：medium
 * @author: moi
 * @create: 2020/12/17 21:52
 **/
public class TreeSubStruct {

    /**
     * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        return subStruct(A,B)|| isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static boolean subStruct(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null || A.val != B.val){
            return false;
        }
        return subStruct(A.left,B.left)&&subStruct(A.right,B.right);
    }
}
