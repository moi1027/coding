package org.moi.algorithm.leecode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: leeCode 第438题 找到字符串中所有字母异位词 难度：中级
 * @author: moi
 * @create: 2020/11/19 20:49
 **/
public class FindAllAnagramsInString {

    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     */

    public static List<Integer> findAnagrams(String s, String p) {
        String[] a = s.split("");
        String[] b = p.split("");
        Map<String,Integer> baseMap = new HashMap<String, Integer>();
        Map<String,Integer> targetMap = new HashMap<String, Integer>();
        for(String c:b){
            if(baseMap.containsKey(c)){
                baseMap.put(c,baseMap.get(c)+1);
            }else{
                baseMap.put(c,1);
            }
        }
        int left = 0,right = 0;
        int variable = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(right<a.length){
            String d = a[right];
            right++;
            if(baseMap.containsKey(d)){
                if(targetMap.containsKey(d)){
                    targetMap.put(d,targetMap.get(d)+1);
                }else{
                    targetMap.put(d,1);
                }
                if(targetMap.get(d).equals(baseMap.get(d))){
                    variable++;
                }
            }
            while(variable == baseMap.size()){
                if(right-left == b.length){
                    list.add(left);
                }
                String e = a[left];
                left++;
                if(baseMap.containsKey(e)){
                    if(targetMap.get(e).equals(baseMap.get(e))){
                        variable--;
                    }
                    targetMap.put(e,targetMap.get(e)-1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        findAnagrams(s,p);
    }
}
