package org.moi.algorithm.leecode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: leeCode 第 652 题 寻找重复的子树 难度：medium
 * @author: moi
 * @create: 2020/11/27 22:40
 **/
public class FindDuplicateSubtrees {


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

    /**
     * 题目：给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     *
     * 两棵树重复是指它们具有相同的结构以及相同的结点值。
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null){
            return null;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        find(root,list,map);
        return list;
    }


    /**
     * 将一颗颗子树转换成字符串，把字符串插入到map中去,以map为判断重复，如果重复了则插入到list中，为了避免重复，只有map中 value为 1 的时候才能添加到list中去
     * @param node
     * @param list
     * @param map
     * @return
     */
    public static String find(TreeNode node,List<TreeNode> list,HashMap<String,Integer> map){
        if(node == null){
            return "#";
        }
        String left = find(node.left,list,map);
        String right = find(node.right,list,map);

        String res = left+","+right+","+node.val;
        int count = map.getOrDefault(res,0);
        if(count > 0){
            list.add(node);
        }
        map.put(res,count+1);
        return res;
    }
}
