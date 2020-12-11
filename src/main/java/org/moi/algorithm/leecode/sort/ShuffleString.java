package org.moi.algorithm.leecode.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: leeCode 第 1528 题 重新排列字符串 难度：easy
 * @author: moi
 * @create: 2020/12/11 22:11
 **/
public class ShuffleString {

    /**
     * 题目：给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
     *
     * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
     *
     * 返回重新排列后的字符串。
     *
     */

    public static String restoreString(String s, int[] indices) {
        StringBuffer sb = new StringBuffer();
        Map map =new HashMap();
        for(int i  = 0;i<indices.length;i++){
            map.put(indices[i],i);
        }
        for(int i = 0;i<indices.length;i++){
            sb.append(s.charAt((Integer) map.get(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] arr = {4,5,6,7,0,2,1,3};
        restoreString(s,arr);
    }

}
