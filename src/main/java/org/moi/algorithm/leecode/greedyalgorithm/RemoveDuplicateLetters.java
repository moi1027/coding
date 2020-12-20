package org.moi.algorithm.leecode.greedyalgorithm;

import java.util.*;

/**
 * @program:
 * @description: 316. 去除重复字母 难度：medium
 * @author: moi
 * @create: 2020/12/20 23:22
 **/
public class RemoveDuplicateLetters {

    /**
     * 题目：给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *
     * 思路：用贪心算法解决
     */

//    public String removeDuplicateLetters(String s) {
//        if(s==null||s==""){
//            return s==null?null:"";
//        }
//        String[] strs = s.split("");
//        List<String> list = new ArrayList<>();
//        Map<String,Integer> map = new HashMap<>();
//        for(int i = 0;i<s.length();i++){
//            map.put(strs[i],map.getOrDefault(strs[i],0));
//            list.add(strs[i]);
//        }
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
//
//    }
}
