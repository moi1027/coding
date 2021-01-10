package org.moi.algorithm.leecode.hashmap;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @program:
 * @description: 49. 字母异位词分组 难度：medium
 * @author: moi
 * @create: 2021/1/10 22:19
 **/
public class GroupAnagrams {

    /**
     * 题目：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 思路：求每个字符的hash值，每个字符串的hash值相等就是字母异位词
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] flag = new int[strs.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 0;
        int[] flag1 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for(String s:strs){
            int num = 1;
            for (int i = 0; i < s.length(); i++) {
                //重点在于这个hash算法的编写
                num+=flag1[s.charAt(i)-'a']*num&Integer.MAX_VALUE;
            }
            flag[n++] = num;
            map.put(num,1);
        }
        for (Integer entry:map.keySet()) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < flag.length; j++) {
                if(entry == flag[j]){
                    list.add(strs[j]);
                }
            }
            res.add(list);
        }
        return res;
    }



    public static void main(String[] args) {
        String[] strs = {"tho","vet"};
        new GroupAnagrams().groupAnagrams(strs);
    }
}
