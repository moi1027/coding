package org.moi.algorithm.leecode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: leeCode 第576题 字符串的排列
 * @author: moi
 * @create: 2020/11/19 9:20
 **/
public class PermutationInString {

    /**
     * 题目：给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 解法：用滑动窗口解决
     */
    public static boolean checkInclusion(String s1, String s2) {
        String[] a = s1.split("");
        String[] b = s2.split("");
        Map<String,Integer> baseMap = new HashMap<String, Integer>();
        Map<String,Integer> targetMap = new HashMap<String,Integer>();
        for(String c:a){
            if(baseMap.containsKey(c)){
                baseMap.put(c,baseMap.get(c)+1);
            }else{
                baseMap.put(c,1);
            }
        }
        int left = 0,right = 0;
        int variable = 0;
        //继续套用模板来解决查找子串的问题，一定要记住滑动窗口模板
        while(right<b.length){
            String d = b[right];
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
                if(right-left == a.length){
                    return true;
                }
                String e = b[left];
                left++;
                if(baseMap.containsKey(e)){
                    if(targetMap.get(e).equals(baseMap.get(e))){
                        variable--;
                    }
                    targetMap.put(e,targetMap.get(e)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1,s2));
    }
}
