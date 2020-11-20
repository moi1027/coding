package org.moi.algorithm.leecode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: leeCode 第76题：最小覆盖子串
 * @author: moi
 * @create: 2020/11/18 20:53
 **/
public class MinimumWindowSubstring {

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 用滑动窗口解决，用left和right双指针来包住窗口，移动左右指针来滑动窗口
     */

    public static String minWindow(String s, String t) {
        String[] a = s.split("");
        String[] b = t.split("");
        Map<String,Integer> baseMap = new HashMap<String, Integer>();
        Map<String,Integer> targetMap = new HashMap<String, Integer>();
        //将t字符串的数据分割成单个字符插入到baseMap中，为了以后好判断窗口中是否存在所有的t中的字符串
        for(String c:b){
            if(baseMap.containsKey(c)){
                baseMap.put(c,baseMap.get(c)+1);
            }else{
                baseMap.put(c,1);
            }
        }
        int left = 0,right = 0;
        int variable = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;

        //滑动窗口的一种模板解决方式
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
                if(right-left<len){
                    len = right-left;
                    start = left;
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
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
