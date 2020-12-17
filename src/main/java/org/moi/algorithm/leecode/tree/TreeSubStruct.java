package org.moi.algorithm.leecode.tree;

/**
 * @program:
 * @description: ��ָoffer �����ӽṹ �Ѷȣ�medium
 * @author: moi
 * @create: 2020/12/17 21:52
 **/
public class TreeSubStruct {

    /**
     * ��Ŀ���������ö�����A��B���ж�B�ǲ���A���ӽṹ��(Լ��������������һ�������ӽṹ)
     *
     * B��A���ӽṹ�� �� A���г��ֺ�B��ͬ�Ľṹ�ͽڵ�ֵ��
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
