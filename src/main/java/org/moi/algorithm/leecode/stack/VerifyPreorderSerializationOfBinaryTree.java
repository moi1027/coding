package org.moi.algorithm.leecode.stack;

/**
 * @program:
 * @description: leeCode 验证二叉树的前序序列化 第331 题 难度： medium
 * @author: moi
 * @create: 2020/12/10 22:01
 **/
public class VerifyPreorderSerializationOfBinaryTree {

    /**
     * 题目：序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
     *
     * 思路:每个合法的节点都要占据一个槽位
     */

    public static boolean isValidSerialization(String preorder) {
        int slots = 1;
        for(int i = 0;i<preorder.length();i++){
            //为了避免一个树的叶子节点是个多位数
            if(preorder.charAt(i)==','){
                --slots;
                if(slots<0){
                    return false;
                }
                if(preorder.charAt(i-1) != '#'){
                    slots+=2;
                }

            }
        }
        slots = preorder.charAt(preorder.length()-1)=='#'?slots-1:slots+1;
        return slots == 0;
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        isValidSerialization(s);
    }
}
